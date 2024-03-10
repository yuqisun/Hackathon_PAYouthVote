#coding:utf-8
import json
import logging
import os
from datetime import timedelta

from flask import Flask, request, url_for
from flask_cors import CORS, cross_origin

app = Flask(__name__)
CORS(app)

from typing import List, Tuple

import numpy as np
from langchain import FAISS
from langchain.embeddings import HuggingFaceEmbeddings
from langchain.docstore.document import Document

PROMPT_TEMPLATE = """
You will be provided with some contonts separated by newlines delimited by triple hashtags, and a question delimited by triple backticks.
Please answer the question concisely and professionally based on the contents provided.
If you cannot get an answer from contents, say "This question cannot be answered based on known information".
Adding fabricated elements to answers is not allowed.
Answer question in English always.

contents: ###{context}###
question: ```{question}```
"""

# model_path = "./model/"
# https://huggingface.co/GanymedeNil/text2vec-large-chinese  apache-2.0 license
embeddings_model = "GanymedeNil/text2vec-large-chinese"
# embeddings_model = "GanymedeNil/text2vec-large-chinese"
embeddings = HuggingFaceEmbeddings(model_name=embeddings_model, model_kwargs={'device': 'cpu'})

CHUNK_SIZE = 250

def seperate_list(ls: List[int]) -> List[List[int]]:
    lists = []
    ls1 = [ls[0]]
    for i in range(1, len(ls)):
        if ls[i - 1] + 1 == ls[i]:
            ls1.append(ls[i])
        else:
            lists.append(ls1)
            ls1 = [ls[i]]
    lists.append(ls1)
    return lists

def similarity_search_with_score_by_vector(
        self, embedding: List[float], k: int = 4,
) -> List[Tuple[Document, float]]:
    scores, indices = self.index.search(np.array([embedding], dtype=np.float32), k)
    docs = []
    id_set = set()
    store_len = len(self.index_to_docstore_id)
    for j, i in enumerate(indices[0]):
        if i == -1:
            # This happens when not enough docs are returned.
            continue
        _id = self.index_to_docstore_id[i]
        doc = self.docstore.search(_id)
        id_set.add(i)
        docs_len = len(doc.page_content)
        for k in range(1, max(i, store_len-i)):
            break_flag = False
            for l in [i + k, i - k]:
                if 0 <= l < len(self.index_to_docstore_id):
                    _id0 = self.index_to_docstore_id[l]
                    doc0 = self.docstore.search(_id0)
                    if docs_len + len(doc0.page_content) > self.chunk_size:
                        break_flag=True
                        break
                    elif doc0.metadata["source"] == doc.metadata["source"]:
                        docs_len += len(doc0.page_content)
                        id_set.add(l)
            if break_flag:
                break
    id_list = sorted(list(id_set))
    id_lists = seperate_list(id_list)
    for id_seq in id_lists:
        for id in id_seq:
            if id == id_seq[0]:
                _id = self.index_to_docstore_id[id]
                doc = self.docstore.search(_id)
            else:
                _id0 = self.index_to_docstore_id[id]
                doc0 = self.docstore.search(_id0)
                doc.page_content += doc0.page_content
        if not isinstance(doc, Document):
            raise ValueError(f"Could not find document for id {_id}, got {doc}")
        doc_score = min([scores[0][id] for id in [indices[0].tolist().index(i) for i in id_seq if i in indices[0]]])
        docs.append((doc, doc_score))
    return docs


def get_docs_with_score(docs_with_score):
    docs = []
    for doc, score in docs_with_score:
        doc.metadata["score"] = score
        docs.append(doc)
    return docs


def get_ref_docs_from_vs(query, vs_path, embeddings=embeddings):
    vector_store = FAISS.load_local(vs_path, embeddings)
    FAISS.similarity_search_with_score_by_vector = similarity_search_with_score_by_vector
    vector_store.chunk_size = CHUNK_SIZE
    related_docs_with_score = vector_store.similarity_search_with_score(query, 20)
    related_docs = get_docs_with_score(related_docs_with_score)
    related_docs.sort(key=lambda x: x.metadata['score'], reverse=True)

    return related_docs


@app.route('/')
@cross_origin()
def index():
    return 'This is for PA vote search'



CANDIDATE_1_VS_ID = "./vector_store/vote_4"


def get_video_ts(ref_file_name, ref_text):
    print(f"### ref_file_name: {ref_file_name}")
    ref_file_name = ref_file_name.replace('.txt', '')
    print(f"### ref_file_name replace: {ref_file_name}")
    logging.info(f"### ref_file_name replace: {ref_file_name}")
    video_path = 'static/video'
    json_path = 'static/json'

    video_file = 'Trump_v_Biden_The_Final_Debate.mp4'
    json_file = 'static/json/Trump_v_Biden_The_Final_Debate.json'

    for root, dirs, files in os.walk(video_path):
        for file in files:
            if file.find(ref_file_name) > -1:
                print(f"video path: {root}/{file}")
                video_file = file
                break
    for root, dirs, files in os.walk(json_path):
        for file in files:
            if file.find(ref_file_name) > -1 and file.find('.json') > -1:
                print(f"json path: {root}/{file}")
                json_file = f"{root}/{file}"
                break

    with open(json_file, encoding='utf-8', errors='ignore') as f:
        data = json.load(f)
        context = data['text']
        segments = data['segments']

        start_idx = context.find(ref_text)
        start_ts = None
        if start_idx > -1:
            str_appender = ''
            for seg in segments:
                str_appender += seg['text']
                if len(str_appender) > start_idx:
                    start_ts = seg['start']
                    break
    print(f"video: {video_file}, text: {json_file}, start timestamp: {start_ts}")
    return video_file, start_ts, ref_text



@app.route('/display_video', methods=['GET'])
@cross_origin()
def display_video():
    args = request.args
    video_file = args['video_file']
    start_ts = max([float(args['start_ts'])-1, 0])
    logging.info(f"Video file: {video_file}, start timestamp: {start_ts}")

    return f"""
        <div style="text-align:center">
            <video id="video1" width="1280" height="720" controls>
                <source src="{url_for('static', filename='video/'+video_file)}" type="video/mp4">
            </video>
        </div>
    """


def get_html_ref(ref_file_name, ref_text):
    text_path = ref_file_name
    url = ''
    title = ''
    with open(text_path, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read().rsplit()
        content = ''.join(content)
        url = 'https://m.thepaper.cn/baijiahao_16210403'
        title = '首届数字金融前沿学术会议举办'
        # ref_text = re.sub(r'<url>(.*?)</url>', '', ref_text, flags=re.DOTALL)
        return url, title, ref_text


def generate_prompt(related_docs: List[str],
                    query: str,
                    prompt_template=PROMPT_TEMPLATE) -> str:
    html_docs = []
    context = ''
    source_documents = []
    ref_number = 0

    for inum, doc in enumerate(related_docs):
        doc_name = os.path.split(doc.metadata['source'])[-1]
        candidate_name = doc_name[:doc_name.index('_')]
        page_content = doc.page_content
        score = round(float(doc.metadata['score']), 2)
        print(f"--- doc: {doc_name}, score: {score} ---")

        if(doc_name.startswith('html_')):
            if(doc_name not in html_docs):
                ref_number += 1
                # html_docs.append(doc_name)
                url, title, ref_text = get_html_ref(doc_name, page_content)
                doc = {'type': 'html', 'candidate': 'candidate_name', 'url': url, 'title': title, 'content': page_content,
                       'score': score}
                source_documents.append(doc)
        else:
            ref_number += 1
            context += f"{ref_number}. {doc.page_content}\n"
            video_file, start_ts, ref_text = get_video_ts(doc_name, page_content)
            if start_ts:
                start_td = timedelta(seconds=start_ts)

                doc = {'type': 'video', 'candidate': 'candidate_name', 'url': f'https://unbiased-popular-stud.ngrok-free.app/static/video/Trump_v_Biden_The_Final_Debate.mp4',
                       'title': video_file, 'content': ref_text, 'score': score, 'start_ts': start_ts}
                source_documents.append(doc)
            # source_documents += f"""<br>{ref_number}. <a href='http://localhost:5000/display_video?video_file={video_file}&start_ts={start_ts}' target='_blank'>{video_file}</a>: {ref_text}(timestamp: {str(start_td)})"""
    prompt = prompt_template.replace("{question}", query).replace(f"{context}", context)
    return prompt, source_documents[:1]


@app.route('/candidate', methods=['GET'])
@cross_origin()
def candidate1():
    args = request.args
    question = args['question']
    print(f"Question for candidate: {question}")
    docs = get_ref_docs_from_vs(question, CANDIDATE_1_VS_ID)
    prompt, source_docs = generate_prompt(docs, question)

    return source_docs


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True, threaded=True)

# http://localhost:5000/candidate?question=how%20to%20build%20a%20great%20school
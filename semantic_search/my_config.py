PROMPT_TEMPLATE = """
You will be provided with some contonts separated by newlines delimited by triple hashtags, and a question delimited by triple backticks.
Please answer the question concisely and professionally based on the contents provided.
If you cannot get an answer from contents, say "This question cannot be answered based on known information".
Adding fabricated elements to answers is not allowed.
Answer question in English always.

contents: ###{context}###
question: ```{question}```
"""

HTML_RESOURCE_PATH = "D:\\SDisk\\workspace\\Python\\vote_search\\static\\html\\"

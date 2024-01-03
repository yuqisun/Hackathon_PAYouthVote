FROM python:3.9
ADD my_config.py /code/
ADD main.py /code/
ADD requirements.txt /code/
ADD vector_store/ /code/vector_store/
ADD static/ /code/static/
ADD model/ /code/model/
WORKDIR /code
RUN pip install -i http://mirrors.aliyun.com/pypi/simple/ --trusted-host mirrors.aliyun.com --default-timeout=60 --no-cache-dir -r requirements.txt
EXPOSE 5000
CMD ["python","-u","main.py"]

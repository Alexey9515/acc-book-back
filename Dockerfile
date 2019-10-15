FROM ubuntu

RUN apt-get update
RUN apt-get install -y openjdk-8-jre

VOLUME /app
WORKDIR /app
COPY ./target /app

CMD java -jar acc-book-back.jar

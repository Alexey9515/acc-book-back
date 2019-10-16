FROM ubuntu

ENV DBUSERNAME postgres
ENV DBPSW root
ENV DBHOST localhost

RUN apt-get update
RUN apt-get install -y openjdk-8-jre

VOLUME /app
WORKDIR /app
COPY ./target /app

EXPOSE 8080

CMD java -Ddb.username=${DBUSERNAME} -Ddb.password=${DBPSW} -Ddb.url=jdbc:postgresql://${DBHOST}:5432/acc-book-db -jar acc-book-back.jar
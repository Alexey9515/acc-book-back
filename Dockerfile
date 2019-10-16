FROM ubuntu

ENV DBUSERNAME
ENV DBPSW
ENV DBHOST

RUN apt-get update
RUN apt-get install -y openjdk-8-jre

VOLUME /app
WORKDIR /app
COPY ./target /a

EXPOSE 8080

CMD java -Ddb.username=${DBUSERNAME} -Ddb.password=${DBPSW} -Ddb.url=jdbc:postgresql://${DBHOST}:5432/acc-book-db -jar acc-book-back.jar
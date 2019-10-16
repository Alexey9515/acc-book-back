FROM ubuntu

ARG dbusername=postgres
ARG dbpassword=root
ARG dbhost=localhost

RUN apt-get update
RUN apt-get install -y openjdk-8-jre

VOLUME /app
WORKDIR /app
COPY ./target /app

EXPOSE 8080

CMD java -jar acc-book-back.jar -Ddb.username=${dbusername} -Ddb.password=${dbpassword} -Ddb.url='jdbc:postgresql://${dbhost}:5432/acc-book-db'

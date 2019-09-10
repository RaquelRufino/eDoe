FROM openjdk:11

COPY ./target/doe-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8085

RUN sh -c 'touch doe-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","doe-0.0.1-SNAPSHOT.jar"]
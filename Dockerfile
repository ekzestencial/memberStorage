FROM openjdk:8-alpine
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/memberStorage-0.0.1-SNAPSHOT.jar $PROJECT_HOME/memberStorage-0.0.1-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo","-Djava.security.egd=file:/dev/./urandom","-jar","./memberStorage-0.0.1-SNAPSHOT.jar"]

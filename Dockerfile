FROM openjdk:8-jdk-alpine

WORKDIR turkish-citizenship-verification-service
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} turkish-citizenship-verification-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","turkish-citizenship-verification-service.jar"]

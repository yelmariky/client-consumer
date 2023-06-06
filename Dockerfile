FROM openjdk:11-jdk-slim-buster
WORKDIR /app

COPY target/*.jar /app/app.jar

ENTRYPOINT java -Dspring.profiles.active=KUBE -jar /app/app.jar
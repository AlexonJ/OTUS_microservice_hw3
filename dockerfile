FROM openjdk:22-jdk-slim-bullseye

# Set metadata for the image
LABEL maintainer="Alexey <fmailp@yandex.ru>"
LABEL description="This is a Docker image based on Debian with java and simple CRUD repository."
LABEL version="1.0"
LABEL release-date="2023-09-28"

EXPOSE 8000
ADD target/crud-users-web-app-1.0.0.jar crudUsersApp.jar
ENTRYPOINT ["java","-jar","/crudUsersApp.jar"]
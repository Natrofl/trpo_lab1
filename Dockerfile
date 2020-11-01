FROM openjdk:8-alpine
WORKDIR /app
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} simpleapi.jar
COPY ./entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
CMD ["entrypoint.sh"]

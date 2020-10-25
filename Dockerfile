FROM maven:3.5.2-jdk-8-alpine as base

FROM base as builder
WORKDIR /build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=builder /build/target/simpleapi-1.0.jar simpleapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","simpleapi.jar"]

FROM openjdk:17-jdk-slim

RUN apt-get update

EXPOSE 6379

COPY target/MVP_Assignment-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["sh", "-c", "java -jar MVP_Assignment-0.0.1-SNAPSHOT.jar"]
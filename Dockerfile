FROM  openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} /usr/local/app.jar
EXPOSE 8080
CMD java -jar /usr/local/app.jar
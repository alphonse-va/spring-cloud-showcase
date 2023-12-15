FROM openjdk:17-jdk-alpine
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>

ADD target/tracing-server.jar tracing-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tracing-server.jar"]
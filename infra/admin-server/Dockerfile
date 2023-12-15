FROM openjdk:21-ea-1-jdk-bullseye
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>

ADD target/admin-server.jar admin-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/admin-server.jar"]
FROM openjdk:21-ea-1-jdk-bullseye
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>
ADD target/config-server.jar /opt/config-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/config-server.jar"]
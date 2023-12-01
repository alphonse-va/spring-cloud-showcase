FROM openjdk:17-jdk-alpine
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>
ADD target/infra-discovery-server.jar infra-discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/infra-discovery-server.jar"]
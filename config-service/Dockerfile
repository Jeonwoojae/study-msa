FROM openjdk:11-jre-slim-buster
VOLUME /tmp
COPY build/libs/config-service-1.0.jar ConfigService.jar
COPY apiEncryptionKey.jks apiEncryptionKey.jks
ENTRYPOINT ["java","-jar","ConfigService.jar"]
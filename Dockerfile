FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/currency1.jar currency1.jar
ENTRYPOINT ["java","-jar","currency1.jar"]
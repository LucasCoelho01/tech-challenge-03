FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/tech-challenge-03-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
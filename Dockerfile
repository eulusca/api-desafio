FROM openjdk:12.2-alpine

COPY build/libs/api-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]
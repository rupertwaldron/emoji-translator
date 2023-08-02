FROM amazoncorretto:17.0.7-alpine
EXPOSE 8080
ADD build/libs/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -Djdk.tls.client.protocols=TLSv1.2 -jar /app.jar"]

# Dockerfile (simple)
FROM eclipse-temurin:17-jdk
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
EXPOSE 8080

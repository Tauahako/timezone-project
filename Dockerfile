FROM eclipse-temurin:17-jdk
RUN groupadd -r spring && useradd --no-log-init -r -g spring spring
USER spring:spring
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
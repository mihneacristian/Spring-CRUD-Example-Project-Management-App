FROM openjdk:11-slim
EXPOSE 8085
ADD target/project_tracker-0.0.1-SNAPSHOT.jar project_tracker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "target/project_tracker-0.0.1-SNAPSHOT.jar"]


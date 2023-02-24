FROM openjdk:11-jdk-slim
COPY target/forex-0.0.1-SNAPSHOT.jar forex-service.jar
ENTRYPOINT ["java","-jar","/forex-service.jar"]

# docker command for build an image:
# docker build --tag=forex-service:latest .

# docker command for run container:
# docker run -p8000:8000 forex-service:latest

# docker command for run two containers on two ports 8000 and 8001:
# docker run -d -p 8000:8000 -p 8001:8000 forex-service:latest
FROM bellsoft/liberica-runtime-container:jre-17-stream-musl as builder
MAINTAINER M.Naeem Akhtar

LABEL maintainer="M.Naeem Akhtar <m.naeem.akhtar@example.com>"
LABEL version="1.0"
LABEL description="My Spring Boot Learning application"

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

#Stage two of DockerFile - here run the spring boot runner inside container
FROM bellsoft/liberica-runtime-container:jre-17-stream-musl

COPY --from=builder target/service-one-0.0.1-SNAPSHOT.jar service-one.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/service-one.jar"]
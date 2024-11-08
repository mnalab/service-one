FROM bellsoft/liberica-runtime-container:jre-17-stream-musl
MAINTAINER M.Naeem Akhtar

LABEL maintainer="M.Naeem Akhtar <m.naeem.akhtar@example.com>"
LABEL version="1.0"
LABEL description="My Spring Boot Learning application"


COPY target/service-one-0.0.1-SNAPSHOT.jar service-one.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/service-one.jar"]

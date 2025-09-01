FROM eclipse-temurin:21-jre
MAINTAINER algebra-it.hr
COPY target/partialExam-0.0.1-SNAPSHOT.jar partialExam3.jar
EXPOSE 8888
ENTRYPOINT [ "java","-jar","/partialExam3.jar" ]
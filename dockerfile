FROM openjdk:11-jre
COPY demo-spring-project-0.0.1-SNAPSHOT.jar /opt/docker/DemoSpringOrg/
WORKDIR /opt/docker/DemoSpringOrg
ENV TZ=Europe/Moscow
EXPOSE 5008
ENTRYPOINT ["java","-jar","demo-spring-project-0.0.1-SNAPSHOT.jar "]
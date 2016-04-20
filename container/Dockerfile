FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD configurator.jar app.jar
ADD iof_configuration.json iof_configuration.json
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

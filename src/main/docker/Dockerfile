FROM openjdk:8-jre
VOLUME /tmp
ADD gateway-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9900
ENTRYPOINT ["java","-Xmx64m","-jar","/app.jar"]
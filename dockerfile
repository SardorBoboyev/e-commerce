FROM openjdk:17-alpine3.13

EXPOSE 8090


COPY  /build/libs/e-commerce-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
FROM openjdk:8-jre
MAINTAINER demo@test.io
ENV MYPATH /
WORKDIR $MYPATH
ARG JAR_FILE=dubbo-demo-spring-boot-provider-3.1.1.jar
COPY ${JAR_FILE} app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8092
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
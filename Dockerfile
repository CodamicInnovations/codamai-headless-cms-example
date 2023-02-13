FROM openjdk:17-jdk-alpine

WORKDIR /data

ENV DEBUG=false
ENV TZ=Europe/Berlin
RUN apk update
RUN apk add ca-certificates curl
RUN update-ca-certificates
RUN rm -rf /var/cache/apk/*
COPY target/GenoBuy-0.0.1.jar ./all.jar
RUN touch ./run.sh
RUN echo "#!/bin/sh" >> ./run.sh
RUN echo "/opt/openjdk-17/bin/java -jar /data/all.jar -Djava.net.preferIPv4Stack=true" >> ./run.sh
RUN chmod -R 0777 ./
EXPOSE 8100

HEALTHCHECK CMD curl -f http://127.0.0.1:8101/actuator/health/ || exit 1;

CMD ["./run.sh"]

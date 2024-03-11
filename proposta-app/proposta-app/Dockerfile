FROM eclipse-temurin:17-jre-alpine
COPY ./target/PropostaService.jar /
WORKDIR /
EXPOSE 8080
RUN apk update && \
    apk add tzdata && \
    cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime && \
    echo "America/Sao_Paulo" >  /etc/timezone && \
    apk del tzdata

CMD java $JAVA_OPTS -jar PropostaService.jar
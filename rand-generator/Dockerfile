FROM amazoncorretto:17

COPY --chown=1000:1000 target/dist /opt/rand-generator

WORKDIR /opt/rand-generator

CMD ["bin/rand-generator"]

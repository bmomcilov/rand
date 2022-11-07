FROM amazoncorretto:17

COPY --chown=1000:1000 rand-tokenizer-application/target/dist /opt/rand-tokenizer

WORKDIR /opt/rand-tokenizer

CMD ["bin/rand-tokenizer"]

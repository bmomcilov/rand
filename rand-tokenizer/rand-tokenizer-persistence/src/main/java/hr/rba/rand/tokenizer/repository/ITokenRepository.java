package hr.rba.rand.tokenizer.repository;

import hr.rba.rand.tokenizer.entities.Token;

import java.time.LocalDateTime;

public interface ITokenRepository {

    long persist(Token token);

    long getCountByTokenName(String token, LocalDateTime from, LocalDateTime to);
}

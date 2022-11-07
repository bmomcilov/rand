package hr.rba.rand.tokenizer.service;

import java.time.LocalDateTime;

public interface ITokenGenerator {

    long newToken();

    long getNumberOfGeneratedTokens(String tokenName, LocalDateTime from, LocalDateTime to);

}

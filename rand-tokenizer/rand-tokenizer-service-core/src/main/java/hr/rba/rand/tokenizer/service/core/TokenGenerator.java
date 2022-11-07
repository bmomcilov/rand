package hr.rba.rand.tokenizer.service.core;

import hr.rba.rand.tokenizer.entities.Token;
import hr.rba.rand.tokenizer.service.IRandomGenerator;
import hr.rba.rand.tokenizer.repository.ITokenRepository;
import hr.rba.rand.tokenizer.service.ITokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

@Service
public class TokenGenerator implements ITokenGenerator {

    private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

    private final IRandomGenerator randomGenerator;
    private final ITokenRepository tokenRepository;

    @Autowired
    public TokenGenerator(IRandomGenerator randomGenerator, ITokenRepository tokenRepository) {
        this.randomGenerator = requireNonNull(randomGenerator);
        this.tokenRepository = requireNonNull(tokenRepository);
    }

    @Override
    public long newToken() {
        int random = randomGenerator.getInt();

        String mapping = null;
        if (random % 3 == 0 && random % 5 == 0) {
            mapping = "RBA";
        } else if (random % 3 == 0) {
            mapping = "R";
        } else if (random % 5 == 0) {
            mapping = "B";
        }

        if (mapping != null) {
            long id = tokenRepository.persist(new Token(null, mapping, LocalDateTime.now()));
            logger.info("New token created '{}', id: {}", mapping, id);
            return id;
        } else {
            logger.warn("Random number ignored: {}", random);
            return -1;
        }
    }

    @Override
    public long getNumberOfGeneratedTokens(String token, LocalDateTime from, LocalDateTime to) {
        requireNonNull(token);
        return tokenRepository.getCountByTokenName(token, from, to);
    }
}

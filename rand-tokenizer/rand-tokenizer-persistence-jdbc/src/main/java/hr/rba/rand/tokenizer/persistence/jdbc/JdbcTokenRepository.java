package hr.rba.rand.tokenizer.persistence.jdbc;

import hr.rba.rand.tokenizer.entities.Token;
import hr.rba.rand.tokenizer.repository.ITokenRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JdbcTokenRepository extends CrudRepository<Token, Long>, ITokenRepository {

    @Override
    default long persist(Token entity) {
        return save(entity).tokenId();
    }

    @Query("""
            SELECT
               COUNT(*)
            FROM
               token
            WHERE
               token_name = :token
               AND ts_insert BETWEEN COALESCE(:from, ts_insert) AND COALESCE(:to, ts_insert)
            """)
    long getCountByTokenName(String token, LocalDateTime from, LocalDateTime to);
}

package hr.rba.rand.tokenizer.rest.resources;

import hr.rba.rand.tokenizer.rest.representations.response.TokenCount;
import hr.rba.rand.tokenizer.service.ITokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    private final ITokenGenerator service;

    @Autowired
    public TokenResource(ITokenGenerator service) {
        this.service = service;
    }

    @GetMapping(value = "/{token}/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenCount> getTokenCount(@PathVariable("token")
                                                    String token,

                                                    @RequestParam(value = "from", required = false)
                                                    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
                                                    LocalDateTime from,

                                                    @RequestParam(value = "to", required = false)
                                                    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
                                                    LocalDateTime to) {
        long tokenCount = service.getNumberOfGeneratedTokens(token, from, to);

        return ResponseEntity.ok(new TokenCount.Builder()
                .success(true)
                .token(token)
                .count(tokenCount)
                .build());
    }
}

package hr.rba.rand.tokenizer.entities;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Token(@Id Long tokenId, String tokenName, LocalDateTime tsInsert) {}

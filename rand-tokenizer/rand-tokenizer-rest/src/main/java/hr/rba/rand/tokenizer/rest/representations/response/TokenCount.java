package hr.rba.rand.tokenizer.rest.representations.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;

@JsonDeserialize(builder = TokenCount.Builder.class)
@Immutable
public interface TokenCount extends BaseResponse {
    final class Builder extends ImmutableTokenCount.Builder {}

    String token();

    long count();

}

package tv.codely.backoffice.authentication.application.authenticate;

import lombok.Getter;
import tv.codely.shared.domain.bus.query.Response;

import java.util.Optional;

@Getter
public final class AuthenticationTokenResponse implements Response {
    private final Optional<String> token;

    private AuthenticationTokenResponse(Optional<String> token) {
        this.token = token;
    }

    public static AuthenticationTokenResponse createAfterAuthenticate(Optional<String> token){
        return new AuthenticationTokenResponse(token);
    }
}

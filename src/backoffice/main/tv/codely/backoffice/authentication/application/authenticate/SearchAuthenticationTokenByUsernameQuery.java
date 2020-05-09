package tv.codely.backoffice.authentication.application.authenticate;

import lombok.Getter;
import tv.codely.shared.domain.bus.query.Query;

import java.util.Optional;

@Getter
public final class SearchAuthenticationTokenByUsernameQuery implements Query {
    private final Optional<String> username;

    private SearchAuthenticationTokenByUsernameQuery(Optional<String> username) {
        this.username    = username;
    }

    public static SearchAuthenticationTokenByUsernameQuery createAfterOfAuthenticate(Optional<String> username){
        return new SearchAuthenticationTokenByUsernameQuery(username);
    }
}

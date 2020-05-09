package tv.codely.backoffice.authentication.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tv.codely.backoffice.authentication.domain.vo.AuthToken;
import tv.codely.shared.domain.AggregateRoot;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class Authentication extends AggregateRoot {
    private final AuthUsername username;
    private final AuthToken token;

    public static Authentication createAfterAuthenticate(AuthUsername username, AuthToken token){
        return new Authentication(username, token);
    }
}

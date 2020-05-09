package tv.codely.backoffice.authentication.domain;

import tv.codely.backoffice.authentication.domain.vo.AuthToken;

import java.util.Optional;

public interface IAuthenticationRepository {
    void save(Authentication afterAuthenticate);

    Optional<AuthToken> findByAuthUsername(AuthUsername username);
}

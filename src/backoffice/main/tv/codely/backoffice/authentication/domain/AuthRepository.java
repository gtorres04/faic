package tv.codely.backoffice.authentication.domain;

import java.util.Optional;

public interface AuthRepository {
    Optional<AuthUser> search(AuthUsername username);
}

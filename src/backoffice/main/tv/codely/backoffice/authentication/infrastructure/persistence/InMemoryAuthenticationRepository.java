package tv.codely.backoffice.authentication.infrastructure.persistence;

import tv.codely.backoffice.authentication.domain.*;
import tv.codely.backoffice.authentication.domain.vo.AuthToken;
import tv.codely.shared.domain.Repository;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class InMemoryAuthenticationRepository implements IAuthenticationRepository {
    private final HashMap<AuthUsername, Authentication> authentications = new HashMap<AuthUsername, Authentication>();

    @Override
    public void save(Authentication authentication) {
        authentications.put(authentication.username(), authentication);
    }

    @Override
    public Optional<AuthToken> findByAuthUsername(AuthUsername username) {
        return Optional.ofNullable(authentications.get(username))
            .map(authentication -> authentication.token());
    }
}

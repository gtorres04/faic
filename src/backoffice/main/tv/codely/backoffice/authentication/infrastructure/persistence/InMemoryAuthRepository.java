package tv.codely.backoffice.authentication.infrastructure.persistence;

import tv.codely.backoffice.authentication.domain.AuthPassword;
import tv.codely.backoffice.authentication.domain.AuthRepository;
import tv.codely.backoffice.authentication.domain.AuthUser;
import tv.codely.backoffice.authentication.domain.AuthUsername;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryAuthRepository implements AuthRepository {
    private final HashMap<AuthUsername, AuthPassword> users = new HashMap<AuthUsername, AuthPassword>() {{
        put(new AuthUsername("javi"), new AuthPassword("barbitas"));
        put(new AuthUsername("rafa"), new AuthPassword("pelazo"));
    }};

    @Override
    public Optional<AuthUser> search(AuthUsername username) {
        return users.containsKey(username)
            ? Optional.of(new AuthUser(username, users.get(username)))
            : Optional.empty();
    }
}

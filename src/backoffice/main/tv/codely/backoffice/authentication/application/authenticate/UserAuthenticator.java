package tv.codely.backoffice.authentication.application.authenticate;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.authentication.domain.*;
import tv.codely.backoffice.authentication.domain.service.authenticate.AuthenticationCreator;
import tv.codely.shared.domain.CaseOfUse;
import tv.codely.shared.domain.InjectDependency;

import java.util.Optional;

@AllArgsConstructor(onConstructor_= {@InjectDependency})
@CaseOfUse
public final class UserAuthenticator {
    private final AuthRepository repository;
    private final AuthenticationCreator authenticationCreator;

    public void authenticate(AuthUsername username, AuthPassword password) {
        Optional<AuthUser> auth = repository.search(username);
        ensureUserExist(auth, username);
        ensureCredentialsAreValid(auth.get(), password);
        authenticationCreator.create(username);
    }

    private void ensureUserExist(Optional<AuthUser> auth, AuthUsername username) {
        if (!auth.isPresent()) {
            throw new InvalidAuthUsername(username);
        }
    }

    private void ensureCredentialsAreValid(AuthUser auth, AuthPassword password) {
        if (!auth.passwordMatches(password)) {
            throw new InvalidAuthCredentials(auth.username());
        }
    }
}

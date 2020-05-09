package tv.codely.backoffice.authentication.usecases.authenticate;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.authentication.domain.*;
import tv.codely.backoffice.authentication.domain.vo.AuthToken;
import tv.codely.shared.domain.CaseOfUse;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;

import java.util.Optional;

@AllArgsConstructor(onConstructor_= @InjectDependency)
@CaseOfUse
public final class AuthenticationTokenSearcher {
    private final IAuthenticationRepository repository;

    public Optional<AuthToken> searchByUsername(AuthUsername username) {
        return repository.findByAuthUsername(username);
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

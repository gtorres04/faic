package tv.codely.backoffice.authentication.domain.service.authenticate;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.authentication.domain.AuthUsername;
import tv.codely.backoffice.authentication.domain.Authentication;
import tv.codely.backoffice.authentication.domain.IAuthenticationRepository;
import tv.codely.backoffice.authentication.domain.vo.AuthToken;
import tv.codely.shared.domain.DomainService;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.UuidGenerator;

import java.util.Optional;

@AllArgsConstructor(onConstructor_= @InjectDependency)
@DomainService
public final class AuthenticationCreator {
    private final IAuthenticationRepository repository;
    private final UuidGenerator uuidGenerator;
    public void create(AuthUsername username) {
        AuthToken token = new AuthToken(uuidGenerator.generateByString(Optional.ofNullable(username.value()))
        .get());
        repository.save(Authentication.createAfterAuthenticate(username, token));
    }
}

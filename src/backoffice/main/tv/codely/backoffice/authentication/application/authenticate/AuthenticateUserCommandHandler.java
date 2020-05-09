package tv.codely.backoffice.authentication.application.authenticate;

import tv.codely.backoffice.authentication.domain.AuthPassword;
import tv.codely.backoffice.authentication.domain.AuthUsername;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateUserCommandHandler implements CommandHandler<AuthenticateUserCommand> {
    private final UserAuthenticator authenticator;

    public AuthenticateUserCommandHandler(UserAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void handle(AuthenticateUserCommand command) {
        AuthUsername username = new AuthUsername(command.username());
        AuthPassword password = new AuthPassword(command.password());

        authenticator.authenticate(username, password);
    }
}

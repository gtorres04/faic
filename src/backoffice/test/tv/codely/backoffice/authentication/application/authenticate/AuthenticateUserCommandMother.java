package tv.codely.backoffice.authentication.application.authenticate;

import tv.codely.backoffice.authentication.domain.AuthPassword;
import tv.codely.backoffice.authentication.domain.AuthPasswordMother;
import tv.codely.backoffice.authentication.domain.AuthUsername;
import tv.codely.backoffice.authentication.domain.AuthUsernameMother;

public final class AuthenticateUserCommandMother {
    public static AuthenticateUserCommand create(AuthUsername username, AuthPassword password) {
        return new AuthenticateUserCommand(username.value(), password.value());
    }

    public static AuthenticateUserCommand random() {
        return create(AuthUsernameMother.random(), AuthPasswordMother.random());
    }
}

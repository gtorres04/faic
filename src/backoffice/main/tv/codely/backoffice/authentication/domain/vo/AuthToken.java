package tv.codely.backoffice.authentication.domain.vo;

import tv.codely.shared.domain.IFinder;
import tv.codely.shared.domain.IdentifierValidation;

public final class AuthToken extends IdentifierValidation {
    public AuthToken(String value) {
        super(value);
    }

    @Override
    public void valid(IFinder finder) {

    }
}

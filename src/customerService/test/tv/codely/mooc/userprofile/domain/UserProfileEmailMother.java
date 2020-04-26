package tv.codely.mooc.userprofile.domain;

import tv.codely.shared.domain.EmailMother;

public final class UserProfileEmailMother {
    public static UserProfileEmail create(String value) {
        return new UserProfileEmail(value);
    }

    public static UserProfileEmail random() {
        return create(EmailMother.random());
    }
}

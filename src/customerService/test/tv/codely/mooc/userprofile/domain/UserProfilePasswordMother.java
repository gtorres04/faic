package tv.codely.mooc.userprofile.domain;

import tv.codely.shared.domain.WordMother;

public final class UserProfilePasswordMother {
    public static UserProfilePassword create(String value) {
        return UserProfilePassword.createPasswordTheFirstTime(value, value);
    }

    public static UserProfilePassword random() {
        return create(WordMother.random());
    }
}

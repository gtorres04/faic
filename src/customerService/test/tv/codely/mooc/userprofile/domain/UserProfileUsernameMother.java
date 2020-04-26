package tv.codely.mooc.userprofile.domain;

import tv.codely.shared.domain.WordMother;

public final class UserProfileUsernameMother {
    public static UserProfileUsername create(String value) {
        return new UserProfileUsername(value);
    }

    public static UserProfileUsername random() {
        return create(WordMother.random());
    }
}

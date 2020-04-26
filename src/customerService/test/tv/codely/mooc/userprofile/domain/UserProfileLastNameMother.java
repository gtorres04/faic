package tv.codely.mooc.userprofile.domain;

import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.WordMother;

public final class UserProfileLastNameMother {
    public static UserProfileLastName create(String value) {
        return new UserProfileLastName(value);
    }

    public static UserProfileLastName random() {
        return create(WordMother.random());
    }
}

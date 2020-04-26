package tv.codely.mooc.userprofile.domain;

import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.WordMother;

public final class UserProfileNameMother {
    public static UserProfileName create(String value) {
        return new UserProfileName(value);
    }

    public static UserProfileName random() {
        return create(WordMother.random());
    }
}

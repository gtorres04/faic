package tv.codely.mooc.userprofile.domain;

import tv.codely.shared.domain.UuidMother;

public final class UserProfileIdMother {
    public static UserProfileId create(String value) {
        return new UserProfileId(value);
    }

    public static UserProfileId random() {
        return create(UuidMother.random());
    }
}

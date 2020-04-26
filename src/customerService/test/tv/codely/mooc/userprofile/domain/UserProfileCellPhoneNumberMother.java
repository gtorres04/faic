package tv.codely.mooc.userprofile.domain;

import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.LongMother;
import tv.codely.shared.domain.WordMother;

public final class UserProfileCellPhoneNumberMother {
    public static UserProfileCellPhoneNumber create(Long value) {
        return new UserProfileCellPhoneNumber(value);
    }

    public static UserProfileCellPhoneNumber randomBetween(long minNumber, long maxNumber) {
        return create(LongMother.numberBetween(minNumber, maxNumber));
    }

    public static UserProfileCellPhoneNumber random() {
        return create(LongMother.random());
    }
}

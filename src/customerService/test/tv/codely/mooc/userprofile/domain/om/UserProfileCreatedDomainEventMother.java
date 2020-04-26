package tv.codely.mooc.userprofile.domain.om;

import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.shared.domain.EmailMother;
import tv.codely.shared.domain.LongMother;
import tv.codely.shared.domain.UuidMother;
import tv.codely.shared.domain.WordMother;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

public final class UserProfileCreatedDomainEventMother {
    public static UserProfileCreatedDomainEvent create(String id, String name, String lastName, Long cellPhoneNumber, String email, String username) {
        return new UserProfileCreatedDomainEvent(id, name, lastName, cellPhoneNumber, email, username);
    }

    public static UserProfileCreatedDomainEvent random() {
        return create(UuidMother.random(),
            WordMother.random(),
            WordMother.random(),
            LongMother.random(),
            EmailMother.random(),
            WordMother.random());
    }
    public static UserProfileCreatedDomainEvent fromUserProfile(UserProfile userProfile) {
        return create(userProfile.id().value(), userProfile.name().value(), userProfile.lastName().value(), userProfile.cellPhoneNumber().value(), userProfile.email().value(), userProfile.username().value());
    }
}

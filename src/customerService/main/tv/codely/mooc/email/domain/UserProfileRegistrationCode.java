package tv.codely.mooc.email.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import tv.codely.mooc.email.domain.vo.*;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.email.UserProfileRegistrationCodeSentDomainEvent;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
public final class UserProfileRegistrationCode extends AggregateRoot {
    private UserProfileRegistrationCodeId id;
    private UserProfileRegistrationCodeUserProfile userProfile;
    private UserProfileRegistrationCodeCode code;
    private UserProfileRegistrationCodeStatus status;
    /*private UserProfileRegistrationCodeDateGeneration dateGeneration;
    private UserProfileRegistrationCodeWaySent waySent;
    private UserProfileRegistrationCodeLastDateSent lastDateSent;*/

    public static UserProfileRegistrationCode create(UserProfileRegistrationCodeId id,
                                                     UserProfileRegistrationCodeUserProfile userProfile,
                                                     UserProfileRegistrationCodeCode code,
                                                     UserProfileRegistrationCodeStatus status/*,
                                                     UserProfileRegistrationCodeDateGeneration dateGeneration,
                                                     UserProfileRegistrationCodeWaySent waySent,
                                                     UserProfileRegistrationCodeLastDateSent lastDateSent*/){
        UserProfileRegistrationCode userProfileRegistrationCode = new UserProfileRegistrationCode(id, userProfile, code, status/*, dateGeneration, waySent, lastDateSent*/);
        userProfileRegistrationCode.record(new UserProfileRegistrationCodeSentDomainEvent(id.value(),
            code.value(),
            userProfile.value().name().value(),
            userProfile.value().lastName().value(),
            userProfile.value().email().value(),
            userProfile.value().username().value(),
            status.value()));
        return userProfileRegistrationCode;
    }
}

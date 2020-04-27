package tv.codely.mooc.email.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import tv.codely.mooc.userprofile.domain.UserProfile;

@Getter
@AllArgsConstructor
@ToString
public final class UserProfileRegistrationCodeUserProfile {
    private final UserProfile value;
}

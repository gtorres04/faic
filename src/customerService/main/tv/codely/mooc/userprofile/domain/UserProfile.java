package tv.codely.mooc.userprofile.domain;

import lombok.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public final class UserProfile {
    private UserProfileId id;
    private UserProfileName name;
    private UserProfileLastName lastName;
    private UserProfileCellPhoneNumber cellPhoneNumber;
    private UserProfileEmail email;
    private UserProfileUsername username;
    private UserProfilePassword password;

}

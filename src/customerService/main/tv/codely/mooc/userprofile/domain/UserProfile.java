package tv.codely.mooc.userprofile.domain;

import lombok.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public final class UserProfile extends AggregateRoot {
    private UserProfileId id;
    private UserProfileName name;
    private UserProfileLastName lastName;
    private UserProfileCellPhoneNumber cellPhoneNumber;
    private UserProfileEmail email;
    private UserProfileUsername username;
    private UserProfilePassword password;

    public static UserProfile create(UserProfileId id,
        UserProfileName name,
        UserProfileLastName lastName,
        UserProfileCellPhoneNumber cellPhoneNumber,
        UserProfileEmail email,
        UserProfileUsername username,
        UserProfilePassword password){
        UserProfile userProfile = new UserProfile(id, name, lastName, cellPhoneNumber, email, username, password);
        userProfile.record(new UserProfileCreatedDomainEvent());
        return userProfile;
    }

}

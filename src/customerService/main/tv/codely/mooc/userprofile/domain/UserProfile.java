package tv.codely.mooc.userprofile.domain;

import lombok.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString(callSuper = true)
public final class UserProfile extends AggregateRoot {
    private UserProfileId id;
    private UserProfileName name;
    private UserProfileLastName lastName;
    private UserProfileCellPhoneNumber cellPhoneNumber;
    private UserProfileEmail email;
    private UserProfileUsername username;
    private UserProfilePassword password;

    private UserProfile(UserProfileId id,
                        UserProfileName name,
                        UserProfileLastName lastName,
                        UserProfileEmail email,
                        UserProfileCellPhoneNumber cellPhoneNumber,
                        UserProfileUsername username){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public static UserProfile create(UserProfileId id,
        UserProfileName name,
        UserProfileLastName lastName,
        UserProfileCellPhoneNumber cellPhoneNumber,
        UserProfileEmail email,
        UserProfileUsername username,
        UserProfilePassword password){
        UserProfile userProfile = new UserProfile(id, name, lastName, cellPhoneNumber, email, username, password);
        userProfile.record(new UserProfileCreatedDomainEvent(id.value(), name.value(), lastName.value(), cellPhoneNumber.value(), email.value(), username.value()));
        return userProfile;
    }


    public static UserProfile createUserProfileForSendRegistrationCode(UserProfileId id,
                                                                       UserProfileName name,
                                                                       UserProfileLastName lastName,
                                                                       UserProfileEmail email,
                                                                       UserProfileCellPhoneNumber cellPhoneNumber,
                                                                       UserProfileUsername username){
        UserProfile userProfile = new UserProfile(id, name, lastName, email, cellPhoneNumber, username);
        return userProfile;
    }

}

package tv.codely.mooc.userprofile.domain;

import tv.codely.mooc.userprofile.application.create.CreateUserProfileRequest;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;

public final class UserProfileMother {
    public static UserProfile create(UserProfileId id,
        UserProfileName name,
        UserProfileLastName lastName,
        UserProfileCellPhoneNumber cellPhoneNumber,
        UserProfileEmail email,
        UserProfileUsername username,
        UserProfilePassword password) {
        return new UserProfile(id, name, lastName, cellPhoneNumber, email, username, password);
    }

    public static UserProfile random() {
        return create(UserProfileIdMother.random(),
            UserProfileNameMother.random(),
            UserProfileLastNameMother.random(),
            UserProfileCellPhoneNumberMother.random(),
            UserProfileEmailMother.random(),
            UserProfileUsernameMother.random(),
            UserProfilePasswordMother.random());
    }

    public static UserProfile fromCreateUserProfileRequest(CreateUserProfileRequest request) {
        return create(UserProfileIdMother.create(request.id()),
            UserProfileNameMother.create(request.name()),
            UserProfileLastNameMother.create(request.lastName()),
            UserProfileCellPhoneNumberMother.create(request.cellPhoneNumber()),
            UserProfileEmailMother.create(request.email()),
            UserProfileUsernameMother.create(request.username()),
            UserProfilePasswordMother.create(request.password()));
    }
}

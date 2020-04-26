package tv.codely.mooc.userprofile.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.userprofile.UserProfileModuleUnitTestCase;
import tv.codely.mooc.userprofile.application.create.om.CreateUserProfileRequestMother;
import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.mooc.userprofile.domain.UserProfileMother;

class UserProfileCreatorShould extends UserProfileModuleUnitTestCase {
    private UserProfileCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        creator = new UserProfileCreator(repository);
    }

    @Test
    void save_a_valid_user_profile() {
        CreateUserProfileRequest createUserProfileRequest = CreateUserProfileRequestMother.random();
        UserProfile userProfile = UserProfileMother.fromCreateUserProfileRequest(createUserProfileRequest);
        creator.create(createUserProfileRequest);
        shouldHaveSaved(userProfile);
    }
}

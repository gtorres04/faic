package tv.codely.mooc.userprofile.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.userprofile.UserProfileModuleUnitTestCase;
import tv.codely.mooc.userprofile.application.create.om.CreateUserProfileRequestMother;
import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.mooc.userprofile.domain.UserProfileMother;
import tv.codely.mooc.userprofile.domain.om.UserProfileCreatedDomainEventMother;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

class UserProfileCreatorShould extends UserProfileModuleUnitTestCase {
    private UserProfileCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();
        creator = new UserProfileCreator(repository, eventBus);
    }

    @Test
    void save_a_valid_user_profile() {
        CreateUserProfileRequest createUserProfileRequest = CreateUserProfileRequestMother.random();
        UserProfile userProfile = UserProfileMother.fromCreateUserProfileRequest(createUserProfileRequest);
        UserProfileCreatedDomainEvent userProfileCreatedDomainEvent = UserProfileCreatedDomainEventMother.fromUserProfile(userProfile);
        creator.create(createUserProfileRequest);
        shouldHaveSaved(userProfile);
    }
}

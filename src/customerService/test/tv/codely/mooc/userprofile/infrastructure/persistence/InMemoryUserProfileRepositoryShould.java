package tv.codely.mooc.userprofile.infrastructure.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.userprofile.domain.*;
import tv.codely.mooc.userprofile.UserProfileModuleInfrastructureTestCase;

import java.util.Optional;

class InMemoryUserProfileRepositoryShould extends UserProfileModuleInfrastructureTestCase {

    @Test
    void save_a_valid_user_profile() {
        UserProfile userProfile = UserProfileMother.random();
        inMemoryUserProfileRepository.save(userProfile);
    }

    @Test
    void search_an_existing_user_profile() {
        UserProfile userProfile = UserProfileMother.random();
        inMemoryUserProfileRepository.save(userProfile);
        Assertions.assertEquals(Optional.of(userProfile), inMemoryUserProfileRepository.search(userProfile.id().value()));
    }

    @Test
    void not_find_non_existing_user_profile() {
        UserProfile userProfile = UserProfileMother.random();
        inMemoryUserProfileRepository.save(userProfile);
        Assertions.assertFalse(inMemoryUserProfileRepository.search(UserProfileIdMother.random().value()).isPresent());
    }
}

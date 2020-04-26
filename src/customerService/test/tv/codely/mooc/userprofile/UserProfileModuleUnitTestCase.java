package tv.codely.mooc.userprofile;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.userprofile.domain.IUserProfileRepository;
import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class UserProfileModuleUnitTestCase extends UnitTestCase {
    protected IUserProfileRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(IUserProfileRepository.class);
    }

    public void shouldHaveSaved(UserProfile userProfile) {
        verify(repository, atLeastOnce()).save(any());
    }
}

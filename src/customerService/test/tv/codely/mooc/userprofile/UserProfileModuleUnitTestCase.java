package tv.codely.mooc.userprofile;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.userprofile.domain.IUserProfileRepository;
import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.shared.domain.UuidGenerator;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class UserProfileModuleUnitTestCase extends UnitTestCase {
    protected IUserProfileRepository repository;
    protected EventBus eventBus;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        eventBus = mock(EventBus.class);
        repository = mock(IUserProfileRepository.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldHaveSaved(UserProfile userProfile) {
        verify(repository, atLeastOnce()).save(any());
    }
    public void shouldHavePublished(DomainEvent domainEvent) {
        verify(eventBus, atLeastOnce()).publish(any());
    }
    public void shouldGenerateUuid(String uuid){
        when(uuidGenerator.generate()).thenReturn(uuid);
    }
}

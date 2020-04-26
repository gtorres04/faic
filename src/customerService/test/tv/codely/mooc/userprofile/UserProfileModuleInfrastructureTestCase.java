package tv.codely.mooc.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.userprofile.domain.IUserProfileRepository;
import tv.codely.mooc.userprofile.infrastructure.InMemoryUserProfileRepository;

public abstract class UserProfileModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    protected InMemoryUserProfileRepository inMemoryUserProfileRepository = new InMemoryUserProfileRepository();
    @Autowired
    protected IUserProfileRepository mySqlUserProfileRepository;
}

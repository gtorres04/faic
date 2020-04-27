package tv.codely.mooc.email.infrastructure;

import tv.codely.mooc.email.domain.IUserProfileRegistrationCodeRepository;
import tv.codely.mooc.email.domain.UserProfileRegistrationCode;
import tv.codely.shared.domain.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class InMemoryUserProfileRegistrationCodeRepository implements IUserProfileRegistrationCodeRepository {
    private Map<String, UserProfileRegistrationCode> userProfileRegistrationCodes = new HashMap<>();
    @Override
    public void save(UserProfileRegistrationCode userProfileRegistrationCode) {
        userProfileRegistrationCodes.put(userProfileRegistrationCode.id().value(), userProfileRegistrationCode);
    }

    @Override
    public Stream<UserProfileRegistrationCode> search() {
        return userProfileRegistrationCodes.values().stream();
    }
}

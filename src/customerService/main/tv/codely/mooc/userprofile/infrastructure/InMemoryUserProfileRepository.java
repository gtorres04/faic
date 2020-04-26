package tv.codely.mooc.userprofile.infrastructure;

import tv.codely.mooc.userprofile.domain.IUserProfileRepository;
import tv.codely.mooc.userprofile.domain.UserProfile;
import tv.codely.shared.domain.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUserProfileRepository implements IUserProfileRepository {
    private final Map<String, UserProfile> usersProfile = new HashMap<>();

    @Override
    public void save(UserProfile userProfile) {
        usersProfile.put(userProfile.id().value(), userProfile);
    }

    @Override
    public Optional<UserProfile> search(String id){
        return Optional.ofNullable(usersProfile.get(id));
    }
}

package tv.codely.mooc.userprofile.domain;

import java.util.Optional;

public interface IUserProfileRepository {
    void save(UserProfile userProfile);

    Optional<UserProfile> search(String id);
}

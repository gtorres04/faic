package tv.codely.mooc.email.domain;

import java.util.stream.Stream;

public interface IUserProfileRegistrationCodeRepository {
    void save(UserProfileRegistrationCode userProfileRegistrationCode);

    Stream<UserProfileRegistrationCode> search();
}

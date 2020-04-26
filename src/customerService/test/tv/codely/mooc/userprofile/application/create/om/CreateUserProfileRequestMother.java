package tv.codely.mooc.userprofile.application.create.om;

import tv.codely.mooc.userprofile.application.create.CreateUserProfileRequest;
import tv.codely.shared.domain.EmailMother;
import tv.codely.shared.domain.LongMother;
import tv.codely.shared.domain.UuidMother;
import tv.codely.shared.domain.WordMother;

public final class CreateUserProfileRequestMother {
    public static CreateUserProfileRequest create(String id,
                                                  String name,
                                                  String lastName,
                                                  Long cellPhoneNumber,
                                                  String email,
                                                  String username,
                                                  String password,
                                                  String passwordConfirm) {
        return new CreateUserProfileRequest(id, name, lastName, cellPhoneNumber, email, username, password, passwordConfirm);
    }

    public static CreateUserProfileRequest random() {
        String pass = WordMother.random();
        return create(UuidMother.random(),
            WordMother.random(),
            WordMother.random(),
            LongMother.random(),
            EmailMother.random(),
            WordMother.random(),
            pass,
            pass);
    }
}

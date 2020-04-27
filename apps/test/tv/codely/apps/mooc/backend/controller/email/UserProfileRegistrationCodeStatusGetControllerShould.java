package tv.codely.apps.mooc.backend.controller.email;

import org.junit.jupiter.api.Test;
import tv.codely.apps.ApplicationTestCase;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

final public class UserProfileRegistrationCodeStatusGetControllerShould extends ApplicationTestCase {
    @Test
    void get_the_status_of_the_registration_code_with_one_user_profile() throws Exception {
        givenISendEventsToTheBus(
            new UserProfileCreatedDomainEvent("fdb388a9-c3a1-4567-8040-04c999e9aa0c", "Gerlin", "Torres",3005226437l, "gtorresoft@gmail.com", "gtorres"),
            new UserProfileCreatedDomainEvent("fdb388a9-c3a1-4567-8040-04c999e9aa0c", "Gerlin", "Torres",3005226437l, "gtorresoft@gmail.com", "gtorres")
        );
        assertResponse("/user-profile-registration-code-status", 200, "{status:\"SENT\"}");
    }
}

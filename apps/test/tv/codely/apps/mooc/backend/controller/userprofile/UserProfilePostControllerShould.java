package tv.codely.apps.mooc.backend.controller.userprofile;

import org.junit.jupiter.api.Test;
import tv.codely.apps.ApplicationTestCase;

final public class UserProfilePostControllerShould extends ApplicationTestCase {
    @Test
    void create_a_user_profile() throws Exception {
        assertRequestWithBody("POST",
            "/user-profile",
            "{\"cellPhoneNumber\":3005226437, \"name\":\"Gerlin\", \"lastName\":\"Torres\", \"username\":\"gtorres\", \"password\":\"123456\", \"passwordConfirm\":\"123456\", \"email\":\"gtorresoft@gmail.com\"}",
            201);
    }
}

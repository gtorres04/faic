package tv.codely.apps.backoffice.backend.controller.auth;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import tv.codely.apps.ApplicationTestCase;

public final class AuthPostControllerShould extends ApplicationTestCase {
    @Test
    void authentication_valid() throws Exception {
        assertRequestWithBody(
            "POST",
            "/auth",
            "{\"username\": \"gtorres\", \"password\": \"5 hours\"}",
            201
        );
    }
}

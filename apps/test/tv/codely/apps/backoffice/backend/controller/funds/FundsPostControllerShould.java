package tv.codely.apps.backoffice.backend.controller.funds;

import org.junit.jupiter.api.Test;
import tv.codely.apps.ApplicationTestCase;

public final class FundsPostControllerShould extends ApplicationTestCase {
    @Test
    void create_a_fund() throws Exception {
        assertRequestWithBody("POST",
            "/funds",
            "{\"name\":\"Natillera\"}",
            201);
    }

    @Test
    void create_two_fund_with_the_same_name() throws Exception {
        assertRequestWithBody("POST",
            "/funds",
            "{\"name\":\"SameName\"}",
            201);
        assertRequestWithBody("POST",
            "/funds",
            "{\"name\":\"SameName\"}",
            400);
    }

    @Test
    void create_a_fund_with_characters_no_valids() throws Exception {
        assertRequestWithBody("POST",
            "/funds",
            "{\"name\":\"\"}",
            400);
        assertRequestWithBody("POST",
            "/funds",
            "{\"name\":12}",
            400);
        assertRequestWithBody("POST",
            "/funds",
            "{}",
            400);
    }
}

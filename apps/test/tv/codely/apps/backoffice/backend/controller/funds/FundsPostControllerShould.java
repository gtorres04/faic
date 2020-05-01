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
        assertRequestWithBodyAndResponseWithBody("POST",
            "/funds",
            "{\"name\":\"SameName\"}",
            400,
            "[{\"error-code\":400,\"user-message\":\"El nombre 'SameName' dado al fondo ya existe en otro fondo\",\"technical-message\":\"N/A\"}]");
    }

    @Test
    void create_a_fund_with_characters_no_valids() throws Exception {
        assertRequestWithBodyAndResponseWithBody("POST",
            "/funds",
            "{\"name\":\"\"}",
            400,
            "[{\"error-code\":400, \"user-message\":\"El nombre del fondo no puede ser vacio\",\"technical-message\":\"N/A\"}]");
        assertRequestWithBodyAndResponseWithBody("POST",
            "/funds",
            "{\"name\":12}",
            400,
            "[{\"error-code\":400, \"user-message\":\"El nombre del fondo no puede inciar con un numero\",\"technical-message\":\"N/A\"}]");
        assertRequestWithBodyAndResponseWithBody("POST",
            "/funds",
            "{}",
            400,
            "[{\"error-code\":400, \"user-message\":\"Para crear el fondo debe enviar un nombre\",\"technical-message\":\"N/A\"}]");
    }
}

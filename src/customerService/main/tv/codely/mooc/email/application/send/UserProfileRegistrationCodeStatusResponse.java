package tv.codely.mooc.email.application.send;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tv.codely.shared.domain.bus.query.Response;

@AllArgsConstructor
@Getter
public final class UserProfileRegistrationCodeStatusResponse implements Response {
    private final String status;
}

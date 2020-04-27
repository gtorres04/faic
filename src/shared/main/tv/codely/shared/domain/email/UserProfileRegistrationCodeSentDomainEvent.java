package tv.codely.shared.domain.email;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public final class UserProfileRegistrationCodeSentDomainEvent extends DomainEvent {
    private final String code;
    private final String name;
    private final String lastName;
    private final String email;
    private final String username;
    private final String status;;

    public UserProfileRegistrationCodeSentDomainEvent(String id, String code, String name, String lastName, String email, String username,
                                                      String status) {
        super(id);
        this.code = code;
        this.name     = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.status = status;
    }

    public UserProfileRegistrationCodeSentDomainEvent(String id, String eventId, String occurredOn, String code, String name, String lastName, String email, String username, String status) {
        super(id);
        this.name     = name;
        this.lastName = lastName;
        this.code = code;
        this.email = email;
        this.username = username;
        this.status = status;
    }

    @Override
    public String eventName() {
        return "userProfile.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("lastName", lastName);
            put("code", code);
            put("email", email);
            put("username", username);
            put("status", status);
        }};
    }

    @Override
    public UserProfileRegistrationCodeSentDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new UserProfileRegistrationCodeSentDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("code"),
            (String) body.get("name"),
            (String) body.get("lastName"),
            (String) body.get("email"),
            (String) body.get("username"),
            (String) body.get("status")
        );
    }
}

package tv.codely.shared.domain.userprofile;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public final class UserProfileCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String lastName;
    private final Long cellPhoneNumber;
    private final String email;
    private final String username;

    public UserProfileCreatedDomainEvent(String id, String name, String lastName, Long cellPhoneNumber, String email, String username) {
        super(id);
        this.name     = name;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.username = username;
    }

    public UserProfileCreatedDomainEvent(String id, String eventId, String occurredOn, String name, String lastName, Long cellPhoneNumber, String email, String username) {
        super(id);
        this.name     = name;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.username = username;
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
            put("cellPhoneNumber", cellPhoneNumber);
            put("email", email);
            put("username", username);
        }};
    }

    @Override
    public UserProfileCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new UserProfileCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("lastName"),
            (Long) body.get("cellPhoneNumber"),
            (String) body.get("email"),
            (String) body.get("username")
        );
    }
}

package tv.codely.shared.domain.funds;

import lombok.*;
import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public final class FundCreatedDomainEvent extends DomainEvent {
    private final String id, name;

    public FundCreatedDomainEvent(String id, String name) {
        super(id);
        this.name     = name;
        this.id = id;
    }

    public FundCreatedDomainEvent(String id, String eventId, String occurredOn, String name) {
        super(id, eventId, occurredOn);
        this.id = name;
        this.name     = name;
    }


    @Override
    public String eventName() {
        return "fund.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}

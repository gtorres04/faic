package tv.codely.shared.domain;

import lombok.ToString;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.exceptions.CreatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ToString
public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new ArrayList<>();
    private List<AValueObject> valueObjects = new ArrayList<>();

    public AggregateRoot(AValueObject ...valueObjects){
        this.valueObjects.addAll(Arrays.asList(valueObjects));
    }

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;

        domainEvents = Collections.emptyList();

        return events;
    }

    final protected void validValueObject(IFinder finder){
        CreatorException creatorException = new CreatorException();
        this.valueObjects.stream().parallel().forEach(aValueObject -> {
            try {
                aValueObject.valid(finder);
            } catch (CreatorException e) {
                creatorException.add(e);
            }
        });
        if(!creatorException.exceptions().isEmpty())
            throw creatorException;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }
}

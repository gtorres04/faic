package tv.codely.shared.domain;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@ToString
public abstract class Identifier implements Serializable {
    @Getter
    final protected String value;

    public Identifier(String value) {
        ensureValidUuid(value);
        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}

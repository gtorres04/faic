package tv.codely.shared.domain;

import lombok.Getter;

import java.util.Objects;

public abstract class StringValueObjectValidation extends AValueObject{
    @Getter
    private String value;

    public StringValueObjectValidation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringValueObjectValidation)) {
            return false;
        }
        StringValueObjectValidation that = (StringValueObjectValidation) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

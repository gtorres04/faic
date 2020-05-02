package tv.codely.shared.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CreatorException extends RuntimeException {
    @Getter
    private List<RuntimeException> exceptions = new ArrayList<>();

    public CreatorException(String msn){
        super(msn);
    }

    public void add(RuntimeException runtimeException){
        exceptions.add(runtimeException);
    }


}

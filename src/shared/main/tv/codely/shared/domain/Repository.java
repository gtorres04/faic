package tv.codely.shared.domain;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@org.springframework.stereotype.Repository
public @interface Repository {
}

package tv.codely.shared.domain;

import java.util.Optional;

public interface UuidGenerator {
    String generate();
    Optional<String> generateByString(Optional<String> stringReference);
}

package tv.codely.shared.infrastructure;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.UuidGenerator;

import java.util.Optional;
import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Optional<String> generateByString(Optional<String> stringReference) {
        return stringReference.map(s -> UUID.nameUUIDFromBytes(s.getBytes()).toString());
    }
}

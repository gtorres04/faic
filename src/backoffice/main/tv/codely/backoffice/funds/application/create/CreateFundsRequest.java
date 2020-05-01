package tv.codely.backoffice.funds.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CreateFundsRequest {
    private final String id, name;
}

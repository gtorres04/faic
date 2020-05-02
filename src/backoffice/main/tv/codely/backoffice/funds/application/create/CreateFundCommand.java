package tv.codely.backoffice.funds.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tv.codely.shared.domain.bus.command.Command;

@AllArgsConstructor
@Getter
public final class CreateFundCommand implements Command {
    private final String id, name;
}

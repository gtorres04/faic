package tv.codely.backoffice.funds.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tv.codely.shared.domain.bus.command.Command;

import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public final class CreateFundCommand implements Command {
    private String id = UUID.randomUUID().toString();
    @NonNull
    private String name;

}

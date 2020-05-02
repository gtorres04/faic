package tv.codely.backoffice.funds.application.create;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.domain.exceptions.FundCreatorException;
import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.usecases.FundsCreator;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.bus.command.CommandHandler;

@tv.codely.shared.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class CreateFundCommandHandler implements CommandHandler<CreateFundCommand> {

    private final FundsCreator creator;
    private final FundsFinder finder;

    @Override
    public void handle(CreateFundCommand command) {
        creator.create(FundId.createFromCommand(command.id()), FundName.createFromCommand(command.name()));
    }
}

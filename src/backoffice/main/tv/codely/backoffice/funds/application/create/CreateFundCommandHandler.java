package tv.codely.backoffice.funds.application.create;

import tv.codely.backoffice.funds.domain.exceptions.FundCreatorException;
import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.usecases.FundsCreator;
import tv.codely.shared.domain.bus.command.CommandHandler;
import tv.codely.shared.domain.exceptions.CreatorException;

@tv.codely.shared.application.CommandHandler
public final class CreateFundCommandHandler implements CommandHandler<CreateFundCommand> {

    private final FundsCreator creator;
    private final FundsFinder finder;

    public CreateFundCommandHandler(FundsCreator creator, FundsFinder finder) {
        this.finder = finder;
        this.creator = creator;
    }

    @Override
    public void handle(CreateFundCommand command) {
        CreatorException creatorException = new CreatorException();
        FundId id = null;
        try {
            id = new FundId(command.id());
        } catch (FundCreatorException e) {
            creatorException.add(e);
        }
        FundName name = null;
        try {
            name = FundName.createFromCommand(command.name());
        } catch (FundNameException e) {
            creatorException.add(e);
        }
        if(!creatorException.exceptions().isEmpty())
            throw creatorException;
        creator.create(id, name);
    }
}

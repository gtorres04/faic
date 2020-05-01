package tv.codely.backoffice.funds.usecases;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.application.create.CreateFundsRequest;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.FundsFinder;
import tv.codely.backoffice.funds.domain.IFundRepository;
import tv.codely.backoffice.funds.domain.exceptions.FundCreatorException;
import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.CaseOfUse;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.domain.exceptions.CreatorException;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class FundsCreator {
    private final IFundRepository fundRepository;
    private final EventBus eventBus;
    private final FundsFinder finder;

    public void create(CreateFundsRequest request) {
        Fund fund = createCatchExceptions(request);
        fundRepository.save(fund);
        eventBus.publish(fund.pullDomainEvents());
    }

    private Fund createCatchExceptions(CreateFundsRequest request) {
        CreatorException creatorException = new CreatorException();
        FundId id = null;
        try {
            id = new FundId(request.id());
        } catch (FundCreatorException e) {
            creatorException.add(e);
        }
        FundName name = null;
        try {
            name = FundName.createToCreateFund(request.name(), finder);
        } catch (FundNameException e) {
            creatorException.add(e);
            throw creatorException;
        }
        return Fund.create(id, name);
    }
}

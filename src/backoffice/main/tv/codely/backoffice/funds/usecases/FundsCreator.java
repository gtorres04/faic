package tv.codely.backoffice.funds.usecases;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.IFundsRepository;
import tv.codely.backoffice.funds.domain.factories.FundFactory;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.CaseOfUse;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.bus.event.EventBus;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class FundsCreator {
    private final IFundsRepository fundRepository;
    private final EventBus eventBus;
    private final FundFactory factory;

    public void create(FundId id, FundName name) {
        Fund fund = factory.create(id, name);
        fundRepository.save(fund);
        eventBus.publish(fund.pullDomainEvents());
    }
}

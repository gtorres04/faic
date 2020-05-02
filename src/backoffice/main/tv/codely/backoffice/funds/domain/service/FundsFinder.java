package tv.codely.backoffice.funds.domain.service;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.domain.IFundsRepository;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.DomainService;
import tv.codely.shared.domain.IFinder;
import tv.codely.shared.domain.InjectDependency;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@DomainService
public final class FundsFinder implements IFinder {
    private final IFundsRepository repository;

    public boolean doesNameOfFundExists(FundName name) {
        return repository.doesNameOfFundExists(name.value());
    }

    public boolean doesIdOfFundExists(FundId id) {
        return repository.doesIdOfFundExists(id.value());
    }
}

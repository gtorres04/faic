package tv.codely.backoffice.funds.domain;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.DomainService;
import tv.codely.shared.domain.InjectDependency;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@DomainService
public final class FundsFinder {
    private final IFundRepository repository;

    public boolean doesNameOfFundExists(FundName name) {
        return repository.doesNameOfFundExists(name.value());
    }
}

package tv.codely.backoffice.funds.domain.factories;

import lombok.AllArgsConstructor;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.Factory;
import tv.codely.shared.domain.InjectDependency;

@AllArgsConstructor(onConstructor_=@InjectDependency)
@Factory
public final class FundFactory {
    private final FundsFinder finder;
    public Fund create(FundId id, FundName name) {
        return Fund.create(id, name, finder);
    }
}

package tv.codely.backoffice.funds.domain;

import lombok.Getter;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.funds.FundCreatedDomainEvent;

@Getter
public final class Fund extends AggregateRoot {
    private final FundId id;
    private final FundName name;

    public static Fund create(FundId id, FundName name, FundsFinder finder) {
        Fund fund = new Fund(id, name, finder);
        fund.record(new FundCreatedDomainEvent(id.value(), name.value()));
        return fund;
    }

    private Fund(FundId id, FundName name, FundsFinder finder) {
        super(id, name);
        validValueObject(finder);
        this.id = id;
        this.name = name;
    }
}

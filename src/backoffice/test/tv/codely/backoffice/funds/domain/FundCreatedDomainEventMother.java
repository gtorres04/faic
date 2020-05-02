package tv.codely.backoffice.funds.domain;

import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundIdMother;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.domain.vo.FundNameMother;
import tv.codely.shared.domain.funds.FundCreatedDomainEvent;

public final class FundCreatedDomainEventMother {
    public static FundCreatedDomainEvent create(FundId id, FundName name) {
        return new FundCreatedDomainEvent(id.value(), name.value());
    }

    public static FundCreatedDomainEvent fromCourse(Fund fund) {
        return create(fund.id(), fund.name());
    }

    public static FundCreatedDomainEvent random() {
        return create(FundIdMother.random(), FundNameMother.random());
    }
}

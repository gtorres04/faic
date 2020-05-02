package tv.codely.backoffice.funds.application.create;

import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundIdMother;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.domain.vo.FundNameMother;

public final class CreateFundCommandMother {
    public static CreateFundCommand create(FundId id, FundName name) {
        return new CreateFundCommand(name.value());
    }

    public static CreateFundCommand random() {
        return create(FundIdMother.random(), FundNameMother.random());
    }
}

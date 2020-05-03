package tv.codely.backoffice.funds.application.create;

import tv.codely.backoffice.funds.domain.vo.FundNameMother;

public final class CreateFundCommandMother {
    public static CreateFundCommand create(String name) {
        return new CreateFundCommand(name);
    }

    public static CreateFundCommand random() {
        return create(FundNameMother.random().value());
    }
}

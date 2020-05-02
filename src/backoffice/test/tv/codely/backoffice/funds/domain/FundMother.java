package tv.codely.backoffice.funds.domain;

import org.mockito.Mockito;
import tv.codely.backoffice.funds.application.create.CreateFundCommand;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundIdMother;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.domain.vo.FundNameMother;

public final class FundMother {
    public static Fund create(FundId id, FundName name) {
        return Fund.create(id, name, Mockito.mock(FundsFinder.class));
    }

    public static Fund fromRequest(CreateFundCommand command) {
        return create(
            FundIdMother.create(command.id()),
            FundNameMother.create(command.name())
        );
    }

    public static Fund random() {
        return create(FundIdMother.random(), FundNameMother.random());
    }
}

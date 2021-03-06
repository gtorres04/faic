package tv.codely.backoffice.funds.domain;

import org.mockito.Mockito;
import tv.codely.backoffice.funds.application.create.CreateFundCommand;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.backoffice.funds.domain.vo.FundId;
import tv.codely.backoffice.funds.domain.vo.FundIdMother;
import tv.codely.backoffice.funds.domain.vo.FundName;
import tv.codely.backoffice.funds.domain.vo.FundNameMother;

public final class FundMother {
    public static Fund create(FundId id, FundName name, FundsFinder fundsFinder) {
        return Fund.create(id, name, fundsFinder);
    }

    public static Fund fromRequest(CreateFundCommand command, FundsFinder fundsFinder) {
        return create(
            FundIdMother.create(command.id()),
            FundNameMother.create(command.name()),
            fundsFinder
        );
    }

    public static Fund random() {
        return create(FundIdMother.random(), FundNameMother.random(), Mockito.mock(FundsFinder.class));
    }
}

package tv.codely.backoffice.funds.domain.vo;

import tv.codely.shared.domain.UuidMother;

public final class FundIdMother {
    public static FundId create(String value) {
        return FundId.createFromCommand(value);
    }

    public static FundId random() {
        return create(UuidMother.random());
    }
}

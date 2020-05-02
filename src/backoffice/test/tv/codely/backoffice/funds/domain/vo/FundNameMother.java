package tv.codely.backoffice.funds.domain.vo;

import tv.codely.shared.domain.WordMother;

public final class FundNameMother {
    public static FundName create(String value) {
        return FundName.createFromCommand(value);
    }

    public static FundName random() {
        return create(WordMother.random());
    }
}

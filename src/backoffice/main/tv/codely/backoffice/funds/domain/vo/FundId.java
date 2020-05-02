package tv.codely.backoffice.funds.domain.vo;

import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.shared.domain.IFinder;
import tv.codely.shared.domain.IdentifierValidation;

public final class FundId extends IdentifierValidation {
    private FundsFinder finder;
    public FundId(String id) {
        super(id);
    }

    @Override
    public void valid(IFinder finder) {
        this.finder = (FundsFinder)finder;
    }
}

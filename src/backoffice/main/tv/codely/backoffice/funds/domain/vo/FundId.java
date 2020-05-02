package tv.codely.backoffice.funds.domain.vo;

import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.shared.domain.IFinder;
import tv.codely.shared.domain.IdentifierValidation;

public final class FundId extends IdentifierValidation {
    private FundsFinder finder;

    private FundId(String value) {
        super(value);
    }

    public static FundId createFromCommand(String value) {
        return new FundId(value);
    }

    @Override
    public void valid(IFinder finder) {
        this.finder = (FundsFinder) finder;
        ensureThatTheFundIdDoesNotExist();
    }

    private void ensureThatTheFundIdDoesNotExist() {
        if(finder.doesIdOfFundExists(this))
            throw new FundNameException(String.format("El Id '%s' dado al fondo ya existe en otro fondo", value()));
    }
}

package tv.codely.backoffice.funds.domain.exceptions;

public final class FundNameException extends FundCreatorException {
    public FundNameException(String msn) {
        super(msn);
    }
}

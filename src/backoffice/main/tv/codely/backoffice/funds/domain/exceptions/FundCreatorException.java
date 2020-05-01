package tv.codely.backoffice.funds.domain.exceptions;

import tv.codely.shared.domain.exceptions.CreatorException;

public class FundCreatorException extends CreatorException {
    public FundCreatorException(String msn){
        super(msn);
    }
}

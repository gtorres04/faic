package tv.codely.backoffice.funds.domain;

import java.util.stream.Stream;

public interface IFundsRepository {
    void save(Fund fund);

    boolean doesNameOfFundExists(String value);
}

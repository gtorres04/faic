package tv.codely.backoffice.funds.domain;

import java.util.stream.Stream;

public interface IFundRepository {
    void save(Fund fund);

    boolean doesNameOfFundExists(String value);
}

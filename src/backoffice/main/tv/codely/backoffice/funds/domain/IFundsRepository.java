package tv.codely.backoffice.funds.domain;


public interface IFundsRepository {
    void save(Fund fund);

    boolean doesNameOfFundExists(String value);

    boolean doesIdOfFundExists(String value);
}

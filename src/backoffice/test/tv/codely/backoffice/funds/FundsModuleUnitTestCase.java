package tv.codely.backoffice.funds;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.IFundsRepository;
import tv.codely.backoffice.funds.domain.factories.FundFactory;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class FundsModuleUnitTestCase extends UnitTestCase {

    protected FundFactory factory;

    protected FundsFinder finder;

    protected IFundsRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(IFundsRepository.class);
        finder = new FundsFinder(repository);
        factory = new FundFactory(finder);
    }

    public void shouldHaveSaved(Fund fund) {
        verify(repository, atLeastOnce()).save(any());
    }
}

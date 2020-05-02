package tv.codely.backoffice.funds;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.IFundsRepository;
import tv.codely.backoffice.funds.domain.factories.FundFactory;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class FundsModuleUnitTestCase extends UnitTestCase {
    protected IFundsRepository repository;
    protected FundFactory factory;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        factory = mock(FundFactory.class);
        repository = mock(IFundsRepository.class);
    }

    public void shouldHaveSaved(Fund fund) {
        verify(repository, atLeastOnce()).save(any());
    }
}

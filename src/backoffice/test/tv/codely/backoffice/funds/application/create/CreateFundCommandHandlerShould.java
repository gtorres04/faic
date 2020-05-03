package tv.codely.backoffice.funds.application.create;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tv.codely.backoffice.funds.FundsModuleUnitTestCase;
import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.FundCreatedDomainEventMother;
import tv.codely.backoffice.funds.domain.FundMother;
import tv.codely.backoffice.funds.domain.vo.FundNameMother;
import tv.codely.backoffice.funds.usecases.FundsCreator;
import tv.codely.shared.domain.exceptions.CreatorException;
import tv.codely.shared.domain.funds.FundCreatedDomainEvent;

final class CreateFundCommandHandlerShould extends FundsModuleUnitTestCase {

    private CreateFundCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateFundCommandHandler(new FundsCreator(repository, eventBus, factory));
    }

    @Test
    void create_a_valid_fund() {
        CreateFundCommand command = CreateFundCommandMother.random();

        Fund fund = FundMother.fromRequest(command, finder);
        FundCreatedDomainEvent domainEvent = FundCreatedDomainEventMother.fromCourse(fund);

        handler.handle(command);

        shouldHaveSaved(fund);
        shouldHavePublished(domainEvent);
    }

    @Test
    void create_two_fund_with_the_same_name() {
        String name = FundNameMother.random().value();
        CreateFundCommand command = CreateFundCommandMother.create(name);

        Fund fund = FundMother.fromRequest(command, finder);
        FundCreatedDomainEvent domainEvent = FundCreatedDomainEventMother.fromCourse(fund);

        handler.handle(command);

        CreateFundCommand commandRepeted = CreateFundCommandMother.create(name);
        Mockito.when(repository.doesNameOfFundExists(commandRepeted.name())).thenReturn(true);

        Assertions.assertThrows(CreatorException.class, () -> handler.handle(commandRepeted));

        shouldHaveSaved(fund);
        shouldHavePublished(domainEvent);
    }

    @Test
    void create_a_fund_with_characters_no_valids() {
        CreateFundCommand commandEmpty = CreateFundCommandMother.create("");
        Assertions.assertThrows(CreatorException.class, () -> handler.handle(commandEmpty));

        CreateFundCommand commandNumber = CreateFundCommandMother.create("12");
        Assertions.assertThrows(CreatorException.class, () -> handler.handle(commandNumber));
    }
}

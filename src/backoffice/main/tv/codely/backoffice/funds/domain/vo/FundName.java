package tv.codely.backoffice.funds.domain.vo;

import tv.codely.backoffice.funds.domain.FundsFinder;
import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.shared.domain.StringValueObject;

import java.util.stream.IntStream;

public final class FundName extends StringValueObject {

    private final FundsFinder finder;

    private FundName(String value, FundsFinder finder) {
        super(value);
        this.finder = finder;
        ensureNull(value);
        ensureEmpty(value);
        ensureNotStartWithNumbers(value);
        ensureThatTheFundNameDoesNotExist(value);
    }
    private FundName(String value){
        super(value);
        this.finder = null;
    }

    public static FundName createToCreateFund(String name, FundsFinder finder){
        return new FundName(name, finder);
    }

    private void ensureNotStartWithNumbers(String value) {
        IntStream.range(0,9).filter(number -> value.startsWith(String.valueOf(number))).findFirst()
            .ifPresent(number -> {
                throw new FundNameException("El nombre del fondo no puede inciar con un numero");
            });
    }

    private void ensureNull(String name) {
        if(null == name)
            throw new FundNameException("Para crear el fondo debe enviar un nombre");
    }

    private void ensureEmpty(String name) {
        if(name.isEmpty())
            throw new FundNameException("El nombre del fondo no puede ser vacio");
    }

    private void ensureThatTheFundNameDoesNotExist(String name) {
        if(finder.doesNameOfFundExists(createFundNameToFinderIfExist(name)))
            throw new FundNameException(String.format("El nombre '%s' dado al fondo ya existe en otro fondo", name));
    }

    private static FundName createFundNameToFinderIfExist(String name) {
        return new FundName(name);
    }
}

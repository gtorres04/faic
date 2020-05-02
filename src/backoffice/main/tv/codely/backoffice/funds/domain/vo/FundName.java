package tv.codely.backoffice.funds.domain.vo;

import tv.codely.backoffice.funds.domain.exceptions.FundNameException;
import tv.codely.backoffice.funds.domain.service.FundsFinder;
import tv.codely.shared.domain.IFinder;
import tv.codely.shared.domain.StringValueObjectValidation;

import java.util.stream.IntStream;

public final class FundName extends StringValueObjectValidation {

    private FundsFinder finder;

    private FundName(String value){
        super(value);
    }

    public static FundName createFromCommand(String name){
        return new FundName(name);
    }

    private static FundName createFundNameToFinderIfExist(String name) {
        return new FundName(name);
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


    @Override
    public void valid(IFinder finder) {
        this.finder = (FundsFinder) finder;
            ensureNull(value());
            ensureEmpty(value());
            ensureNotStartWithNumbers(value());
            ensureThatTheFundNameDoesNotExist(value());
    }
}

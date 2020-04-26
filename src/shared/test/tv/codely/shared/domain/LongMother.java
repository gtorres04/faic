package tv.codely.shared.domain;

public final class LongMother {
    public static Long random() {
        return MotherCreator.random().number().randomNumber();
    }
    public static Long numberBetween(long minNumber, long maxNumber) {
        return MotherCreator.random().number().numberBetween(minNumber, maxNumber);
    }
}

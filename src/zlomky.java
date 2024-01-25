public class Fraction {
    private final int citatel;
    private final int jmenovatel;

    public Fraction(int citatel, int jmenovatel) {
        if (jmenovatel == 0) {
            throw new IllegalArgumentException("Jmenovatel se nemuze rovnat nule");
        }

        int kombinaceZlomek = kombinaceZlomek(Math.abs(citatel), Math.abs(jmenovatel));
        if (jmenovatel < 0) {
            kombinaceZlomek = -kombinaceZlomek;
        }
        this.citatel = citatel / kombinaceZlomek;
        this.jmenovatel = jmenovatel / kombinaceZlomek;
    }

    public Fraction add(Fraction other) {
        int newCitatel = this.citatel * other.jmenovatel + other.citatel * this.jmenovatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new Fraction(newCitatel, newJmenovatel);
    }

    public Fraction subtract(Fraction other) {
        int newCitatel = this.citatel * other.jmenovatel - other.citatel * this.jmenovatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new Fraction(newCitatel, newJmenovatel);
    }

    public Fraction multiply(Fraction other) {
        int newCitatel = this.citatel * other.citatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new Fraction(newCitatel, newJmenovatel);
    }

    public Fraction divide(Fraction other) {
        if (other.citatel == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int newNumerator = this.citatel * other.jmenovatel;
        int newDenominator = this.jmenovatel * other.citatel;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction reciprocal() {
        return new Fraction(this.jmenovatel, this.citatel);
    }

    public double toReal() {
        return (double) citatel / jmenovatel;
    }

    @Override
    public String toString() {
        return citatel + "/" + jmenovatel;
    }

    private static int kombinaceZlomek(int zlomekA, int zlomekB) {
        while (zlomekB != 0) {
            int t = zlomekB;
            zlomekB = zlomekA % zlomekB;
            zlomekA = t;
        }
        return zlomekA;
    }
}
public class zlomky {
    private final int citatel;
    private final int jmenovatel;

    public zlomky(int citatel, int jmenovatel) {
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

    public zlomky add(zlomky other) {
        int newCitatel = this.citatel * other.jmenovatel + other.citatel * this.jmenovatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new zlomky(newCitatel, newJmenovatel);
    }

    public zlomky subtract(zlomky other) {
        int newCitatel = this.citatel * other.jmenovatel - other.citatel * this.jmenovatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new zlomky(newCitatel, newJmenovatel);
    }

    public zlomky multiply(zlomky other) {
        int newCitatel = this.citatel * other.citatel;
        int newJmenovatel = this.jmenovatel * other.jmenovatel;
        return new zlomky(newCitatel, newJmenovatel);
    }

    public zlomky divide(zlomky other) {
        if (other.citatel == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int newCitatel = this.citatel * other.jmenovatel;
        int newJmenovatel = this.jmenovatel * other.citatel;
        return new zlomky(newCitatel, newJmenovatel);
    }

    public zlomky reciprocal() {
        return new zlomky(this.jmenovatel, this.citatel);
    }

    public double prevodNaCeleCislo() {
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
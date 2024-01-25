public class Main {
    public static void main(String[] args) {
        zlomky zlomekA = new zlomky(8, 4);
        zlomky zlomekB = new zlomky(1, 4);

        System.out.println("První číslo: " + zlomekA + "\nCelé číslo: " + zlomekA.prevodNaCeleCislo());
        System.out.println(" ");
        System.out.println("Druhé číslo: " + zlomekB + "\nCelé číslo: " + zlomekB.prevodNaCeleCislo());
        System.out.println(" ");
        zlomky scitani = zlomekA.add(zlomekB);
        System.out.println("Sčítání: " + scitani + "\nCelé číslo: " + scitani.prevodNaCeleCislo());
        System.out.println(" ");
        zlomky odecitani = zlomekA.subtract(zlomekB);
        System.out.println("Odečítání: " + odecitani + "\nCelé číslo: " + odecitani.prevodNaCeleCislo());
        System.out.println(" ");
        zlomky nasobeni = zlomekA.multiply(zlomekB);
        System.out.println("Násobení: " + nasobeni + "\nCelé číslo: " + nasobeni.prevodNaCeleCislo());
        System.out.println(" ");
        zlomky deleni = zlomekA.divide(zlomekB);
        System.out.println("Dělení: " + deleni + "\nCelé číslo: " + deleni.prevodNaCeleCislo());
    }
}

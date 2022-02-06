package pl.javastart.unittestruncycle;

public class UnitTestRunCycle {

    /*
    Metoda main nie ma związku z testami przeprowadzonymi w klasie
    UnitTestRunCycleTest
    Metoda main sprawdza zachowanie przy użyciu słów kluczowych:
    static oraz this
     */

    public static void main(String[] args) {
        Car car = new Car();
        Car bmw = new Car("BMW", 2500);
        Car mercedes = new Car("Mercedes", 3000);

        int number = Car.numberOfCars;
        System.out.println(number);
        car.print();
        bmw.print();
    }

    private static class Car {
        private String name;
        private int engineCapacity;

        public static int numberOfCars = 0;

        public Car() {
        }

        public Car(String name, int engineCapacity) {
            this.name = name;
            this.engineCapacity = engineCapacity;
            numberOfCars++;
        }

        private void print() {
            System.out.println("Wyświetl: " + this);
        }

        @Override
        public String toString() {
            return "Car= " + name + " " + engineCapacity;
        }
    }

}

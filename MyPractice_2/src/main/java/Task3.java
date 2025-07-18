import java.util.*;

class Car implements Comparable<Car> {
    private final String vin;
    private final String model;
    private final String manufacturer;
    private final int year;
    private final int mileage;
    private final double price;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getMileage() { return mileage; }
    public double getPrice() { return price; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year); // от новых к старым
    }

    @Override
    public String toString() {
        return vin + " | " + model + " | " + manufacturer + " | " + year + " | " + mileage + " км | $" + price;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("1", "Camry", "Toyota", 2022, 30000, 25000));
        cars.add(new Car("2", "X5", "BMW", 2021, 45000, 50000));
        cars.add(new Car("1", "Camry", "Toyota", 2022, 30000, 25000)); // дубликат VIN

        System.out.println("Машины без дубликатов:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

import java.util.*;
import java.util.stream.*;

public class Task4 {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("A1", "Camry", "Toyota", 2020, 40000, 20000),
                new Car("B2", "Model S", "Tesla", 2021, 10000, 80000),
                new Car("C3", "X5", "BMW", 2019, 55000, 35000),
                new Car("D4", "Solaris", "Hyundai", 2018, 30000, 15000),
                new Car("E5", "Granta", "Lada", 2020, 48000, 8000)
        );

        // 1. Машины с пробегом < 50_000
        List<Car> lowMileage = cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .collect(Collectors.toList());

        // 2. Сортировка по цене по убыванию
        List<Car> sortedByPrice = lowMileage.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .collect(Collectors.toList());

        // 3. Топ-3 дорогие
        System.out.println("Топ-3 дорогих машины с пробегом < 50_000:");
        sortedByPrice.stream().limit(3).forEach(System.out::println);

        // 4. Средний пробег
        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.println("Средний пробег: " + avgMileage);

        // 5. Группировка по производителю
        Map<String, List<Car>> grouped = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Группировка по производителю:");
        for (var entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue().size() + " машины");
        }
    }
}

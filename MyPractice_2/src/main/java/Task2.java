import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>(Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S", "BMW X5", "Tesla Model 3", "Lada Granta"
        ));

        // Удаление дубликатов
        Set<String> uniqueModels = new TreeSet<>(Collections.reverseOrder());
        for (String model : models) {
            if (model.contains("Tesla")) {
                model = "ELECTRO_CAR";
            }
            uniqueModels.add(model);
        }

        // Вывод отсортированных моделей
        System.out.println("Уникальные модели в обратном порядке:");
        for (String model : uniqueModels) {
            System.out.println(model);
        }

        // Сохранение в Set
        Set<String> finalModelSet = new HashSet<>(uniqueModels);
    }
}

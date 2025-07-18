import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] years = new int[50];
        Random random = new Random();

        // Заполнение массива случайными годами (2000–2025)
        for (int i = 0; i < years.length; i++) {
            years[i] = random.nextInt(2026 - 2000) + 2000;
        }

        // Вывод машин, выпущенных после 2015
        System.out.println("Машины после 2015 года:");
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }

        // Подсчет среднего возраста
        int currentYear = 2025;
        int totalAge = 0;
        for (int year : years) {
            totalAge += (currentYear - year);
        }

        double averageAge = (double) totalAge / years.length;
        System.out.println("\nСредний возраст машин: " + averageAge);
    }
}

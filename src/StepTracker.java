import java.util.Scanner;

class StepTracker {
    private final MonthData[] monthToData = new MonthData[12];
    private final Scanner scanner;
    private int goalByStepsPerDay = 10000;
    private final Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("-".repeat(20));
        System.out.print("Введите номер месяца: ");
        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введено неверное значение номера месяца.");
            return;
        }

        System.out.print("Введите номер дня: ");
        int dayNumber = scanner.nextInt();

        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Введено неверное значение номера дня.");
            return;
        }

        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Количество шагов меньше или равно нулю.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[dayNumber - 1] = steps;

        System.out.println("Введенное количество шагов сохранено в программу.");
    }

    void changeStepGoal() {
        System.out.println("-".repeat(20));
        System.out.print("Введите количество шагов для достижения дневной цели: ");
        int inputGoalByStepsPerDay = scanner.nextInt();

        if (inputGoalByStepsPerDay <= 0) {
            System.out.println("Количество шагов меньше или равно нулю.");
            return;
        }

        goalByStepsPerDay = inputGoalByStepsPerDay;

        System.out.println("Введенное количество шагов для достижения цели сохранено в программу.");
    }

    void printStatistic() {
        System.out.println("-".repeat(20));
        System.out.print("Введите номер месяца: ");
        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введено неверное значение номера месяца.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        int sumStepsFromMonth = monthData.sumStepsFromMonth();

        System.out.println("Статистика за " + monthNumber + " месяц:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumStepsFromMonth);
        System.out.println("Масимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее пройденное количество шагов в месяце: " + monthData.avgSteps());
        System.out.println("Пройденная дистанция в километрах: " + converter.convertToKm(sumStepsFromMonth) + "км");
        System.out.println("Количество сожжённых килокалорий: "
                + converter.convertStepsToKilocalories(sumStepsFromMonth) + "ккал");
        System.out.println("Лучшая серия - максимальное количество подряд идущих дней, "
                + "в течение которых количество шагов за день было равно или выше целевого: "
                + monthData.bestSeries(goalByStepsPerDay));


    }
}

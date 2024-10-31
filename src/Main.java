import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();

                switch (command) {
                    case 1:
                        stepTracker.addNewNumberStepsPerDay();
                        break;
                    case 2:
                        stepTracker.changeStepGoal();
                        break;
                    case 3:
                        stepTracker.printStatistic();
                        break;
                    case 4:
                        System.out.println("Выход из приложения...");
                        return;
                    default:
                        System.out.println("Такой операции нет!");

                }
            } else {
                System.out.println("Неверный ввод! Введите число");
                scanner.next();
            }
        }
    }

    private static void printMenu() {
        System.out.println("-".repeat(20));
        System.out.println("Вас приветствует приложение по подсчету калорий!");
        System.out.println("Введите номер операции:");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Изменить цель по количеству шагов в день.");
        System.out.println("3 - Напечатать статистику за определённый месяц.");
        System.out.println("4 - Выйти из приложения");
        System.out.println("-".repeat(20));
    }
}
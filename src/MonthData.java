class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int steps : days) {
            sumSteps += steps;
        }

        return sumSteps;
    }

    int avgSteps() {
        return sumStepsFromMonth() / days.length;
    }

    int maxSteps() {
        int max = days[0];

        for (int steps : days) {
            max = Math.max(max, steps);
        }

        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int bestSeries = 0;

        for (int steps : days) {
            if (steps >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }

        return bestSeries;
    }
}

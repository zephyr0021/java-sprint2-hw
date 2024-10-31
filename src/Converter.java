class Converter {
    int santimetersInStep = 75;
    int caloriesInStep = 50;
    double santimetersInkilometer = 100000;
    double caloriesInKilocalorie = 1000;

    double convertToKm(int steps) {
        return (steps * santimetersInStep) / santimetersInkilometer;
    }

    double convertStepsToKilocalories(int steps) {
        return (steps * caloriesInStep) / caloriesInKilocalorie;
    }
}

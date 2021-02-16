package utils;

public class UtilsHelper {

    public static int getUniqueRowsFromNumberOfVariables(int numberOfVariables) {
        int numberOfPossibleUniqueRows = 2;
        for (int i = 0; i < numberOfVariables - 1; i++) {
            numberOfPossibleUniqueRows *= 2;
        }
        return numberOfPossibleUniqueRows;
    }
}

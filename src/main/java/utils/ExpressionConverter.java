package utils;

public class ExpressionConverter {

    public static String convertExpression(String expression) {
        String trimmedExpression = expression.replaceAll(" ", "");
        String convertedExpression = ConvertCharactors(trimmedExpression);
        return AddSpaces(convertedExpression);
    }

    private static String ConvertCharactors(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '!':
                    result += "¬";
                    break;
                case '&':
                    result += "∧";
                    i++;
                    break;
                case '|':
                    result += "∨";
                    i++;
                    break;
                default:
                    result += c;
            }
        }
        return result;
    }

    private static String AddSpaces(String expression) {
        String result = "";
        for (char c : expression.toCharArray()) {
            if (c == '!' || c == '¬') {
                result += c;
            } else {
                result += String.format("%c ", c);
            }
        }
        return result;
    }
}

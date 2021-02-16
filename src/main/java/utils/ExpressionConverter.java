package utils;

import java.util.ArrayList;
import java.util.List;
import static utils.UtilsHelper.isCharactorBetween;
import utils.enums.ExpressionTypes;

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

    public static List<Character> convertExpressionToVariableLetters(String expression) {
        List<Character> variableLetters = new ArrayList();
        for (char c : expression.toCharArray()) {
            if (isCharactorBetween(c, 97, 122) || isCharactorBetween(c, 65, 90)) {
                if (!variableLetters.contains(c)) {
                    variableLetters.add(c);
                }
            }
        }
        return variableLetters;
    }

    public static String replaceExpressionPlaceholders(String expression, List<Character> variableLetters, List<ExpressionTypes> row) {
        String result = expression;
        for (int i = 0; i < variableLetters.size(); i++) {
            String currentPlaceholder = String.format("%c", variableLetters.get(i));
            String currentBoolean = row.get(i).equals(ExpressionTypes.TRUE) ? "true" : "false";
            result = result.replaceAll(currentPlaceholder, currentBoolean);
        }
        return result;
    }
}

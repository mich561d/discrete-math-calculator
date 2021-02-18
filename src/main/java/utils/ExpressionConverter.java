package utils;

import java.util.ArrayList;
import java.util.List;
import static utils.UtilsHelper.isCharactorBetween;
import utils.enums.ExpressionTypes;

public class ExpressionConverter {

    public static String convertExpression(String expression) {
        String trimmedExpression = expression.replaceAll(" ", "");
        String convertedExpression = convertCharactors(trimmedExpression);
        return addSpaces(convertedExpression).trim();
    }

    private static String convertCharactors(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '!':
                    if (i + 1 <= expression.length() && expression.charAt(i + 1) == '=') {
                        result += "≠";
                        i++;
                        break;
                    }
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
                case '=':
                    result += "≡";
                    i++;
                default:
                    result += c;
            }
        }
        return result;
    }

    private static String addSpaces(String expression) {
        String result = "";
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ( c == '¬' || c == '(') {
                result += c;
            } else {
                if (i + 1 < chars.length && chars[i + 1] == ')') {
                    result += c;
                } else {
                    result += String.format("%c ", c);
                }
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

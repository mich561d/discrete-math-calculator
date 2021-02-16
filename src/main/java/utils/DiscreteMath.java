package utils;

import java.util.ArrayList;
import java.util.List;
import utils.DTOs.CalculationDTO;
import utils.enums.ExpressionTypes;

public class DiscreteMath {

    public static List<String> getSymbols() {
        List<String> symbols = new ArrayList();
        symbols.add("!  <=> ¬ = not");
        symbols.add("&& <=> ∧ = and");
        symbols.add("|| <=> ∨ = or");
        return symbols;
    }

    public static CalculationDTO calculateExpression(String expression) {
        String convertedExpression = ExpressionConverter.convertExpression(expression);
        List<String> headers = createHeaders(convertedExpression);
        List<List<ExpressionTypes>> rows = createRows(headers);
        return new CalculationDTO(convertedExpression, headers, rows);
    }

    private static List<String> createHeaders(String expression) {
        List<String> headers = new ArrayList();
        for (char c : expression.toCharArray()) {
            if (isCharactorBetween(c, 97, 122) || isCharactorBetween(c, 65, 90)) {
                if (!headers.contains(String.format("%c", c))) {
                        headers.add(String.format("%c", c));
                }
            }
        }
        headers.add(expression);
        return headers;
    }
    
    private static boolean isCharactorBetween(char c, int min, int max) {
        int charAsInt = c;
        return charAsInt >= min && charAsInt <= max;
    }

    private static List<List<ExpressionTypes>> createRows(List<String> headers) {
        List<List<ExpressionTypes>> rows = new ArrayList();
        int numberOfVariables = headers.size() - 1;
        for (int i = 0; i < numberOfVariables; i++) {
            List<ExpressionTypes> row = new ArrayList();

            row.add(ExpressionTypes.TRUE);
            row.add(ExpressionTypes.FALSE);

            row.add(ExpressionTypes.UNKNOWN);
            rows.add(row);
        }
        return rows;
    }
}

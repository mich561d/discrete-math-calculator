package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import utils.DTOs.CalculationDTO;
import utils.DTOs.ExpressionRuleDTO;
import static utils.ExpressionConverter.convertExpression;
import static utils.ExpressionConverter.convertExpressionToVariableLetters;
import static utils.ExpressionConverter.replaceExpressionPlaceholders;
import static utils.HardcodedRows.variablesToRows;
import static utils.UtilsHelper.isCharactorBetween;
import utils.enums.ExpressionTypes;

public class DiscreteMath {

    public static List<ExpressionRuleDTO> getSymbols() {
        List<ExpressionRuleDTO> symbols = new ArrayList();
        symbols.add(new ExpressionRuleDTO("Placeholders", "Placeholders means variables in the expression, a veriable in the expression is simply a letter. You can use either lowercase or uppercase letters", "a"));
        symbols.add(new ExpressionRuleDTO("Negation", "Negation means not the case that 'a'. In the expression use '!' it will automatically be converted to '¬'.", "!a"));
        symbols.add(new ExpressionRuleDTO("Conjuction", "Conjuction means both 'a' and 'b'. In the expression use '&&' it will automatically be converted to '∧'.", "a && b"));
        symbols.add(new ExpressionRuleDTO("Disjunction", "Disjunction means either 'a' or 'b'. In the expression use '||' it will automatically be converted to '∨'.", "a || b"));
        symbols.add(new ExpressionRuleDTO("Parentheses", "In the expression use '(' and ')' as normal. Parentheses will make sure certain statements will be evaluated before others.", "(a && b) || (c && d)"));
        symbols.add(new ExpressionRuleDTO("Exclusive disjunction", "Exclusive disjunction means either 'a' or 'b', but not both.", "(a || b) && !(a && b)"));
        symbols.add(new ExpressionRuleDTO("Tautology", "Something that is always true is called a tautology. In the expression use '==' it will automatically be converted to '≡'.", "a == a"));
        symbols.add(new ExpressionRuleDTO("Contradiction", "Something that can never be true is called a contradiction. In the expression use '!=' it will automatically be converted to '≠'", "a != a"));
        return symbols;
    }
    

    public static CalculationDTO calculateExpression(String expression) {
        String convertedExpression = convertExpression(expression);
        List<String> headers = createHeaders(convertedExpression);
        List<List<ExpressionTypes>> rows = createRows(headers);
        evaluateExpressionWithRows(expression, rows);
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

    private static List<List<ExpressionTypes>> createRows(List<String> headers) {
        int numberOfVariables = headers.size() - 1;
        return variablesToRows(numberOfVariables);
        /* Some code I havn'nt made work yet
        List<List<ExpressionTypes>> rows = new ArrayList();
        int uniqueRows = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        for (int i = 0; i < uniqueRows; i++) {
            List<ExpressionTypes> row = new ArrayList();
            row.add(ExpressionTypes.UNKNOWN);
            rows.add(row);
        }

        return rows;
         */
    }

    private static void evaluateExpressionWithRows(String expression, List<List<ExpressionTypes>> rows) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        List<Character> variableLetters = convertExpressionToVariableLetters(expression);

        for (List<ExpressionTypes> row : rows) {
            String expressionWithValues = replaceExpressionPlaceholders(expression, variableLetters, row);
            try {
                boolean evaluatedExpression = (boolean) engine.eval(expressionWithValues);
                row.set(row.size() - 1, evaluatedExpression ? ExpressionTypes.TRUE : ExpressionTypes.FALSE);
            } catch (ScriptException ex) {
                Logger.getLogger(DiscreteMath.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

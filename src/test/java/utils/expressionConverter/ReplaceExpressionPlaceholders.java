package utils.expressionConverter;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.ExpressionConverter;
import utils.enums.ExpressionTypes;

public class ReplaceExpressionPlaceholders {

    @Test
    public void MustReplaceAWithTrueInExpression() {
        String expression = "a";
        List<Character> variableLetters = new ArrayList();
        variableLetters.add('a');
        List<ExpressionTypes> row = new ArrayList();
        row.add(ExpressionTypes.TRUE);
        String expResult = "true";
        String result = ExpressionConverter.replaceExpressionPlaceholders(expression, variableLetters, row);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustReplaceAWithTrueAndBWithFalseInExpression() {
        String expression = "a && b";
        List<Character> variableLetters = new ArrayList();
        variableLetters.add('a');
        variableLetters.add('b');
        List<ExpressionTypes> row = new ArrayList();
        row.add(ExpressionTypes.TRUE);
        row.add(ExpressionTypes.FALSE);
        String expResult = "true && false";
        String result = ExpressionConverter.replaceExpressionPlaceholders(expression, variableLetters, row);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustReplaceATwiceWithTrueAndBWithFalseInExpression() {
        String expression = "a && (!b || a)";
        List<Character> variableLetters = new ArrayList();
        variableLetters.add('a');
        variableLetters.add('b');
        List<ExpressionTypes> row = new ArrayList();
        row.add(ExpressionTypes.FALSE);
        row.add(ExpressionTypes.TRUE);
        String expResult = "false && (!true || false)";
        String result = ExpressionConverter.replaceExpressionPlaceholders(expression, variableLetters, row);
        assertEquals(expResult, result);
    }
}

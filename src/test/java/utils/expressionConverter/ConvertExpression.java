package utils.expressionConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.ExpressionConverter;

public class ConvertExpression {

    @Test
    public void MustRemoveUnwantedSpacesFromExpression() {
        String expression = " a ";
        String expResult = "a";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustConvertNotSymbol() {
        String expression = "!a";
        String expResult = "¬a";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustConvertAndSymbol() {
        String expression = "a && b";
        String expResult = "a ∧ b";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustConvertOrSymbol() {
        String expression = "a || b";
        String expResult = "a ∨ b";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustNotConvertParenthesesSymbols() {
        String expression = "(a)";
        String expResult = "(a)";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void MustConvertExpressionCorrectly() {
        String expression = "a && (!b || c)";
        String expResult = "a ∧ (¬b ∨ c)";
        String result = ExpressionConverter.convertExpression(expression);
        assertEquals(expResult, result);
    }
}

package utils.expressionConverter;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.ExpressionConverter;

public class ConvertExpressionToVariableLetters {

    @Test
    public void AMustGiveSingleCharacter() {
        String expression = "a";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void NotAMustGiveSingleCharacter() {
        String expression = "!a";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void AAndBMustGiveTwoCharacters() {
        String expression = "a && b";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        expResult.add('b');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void AAndNotBOrCMustGiveThreeCharacters() {
        String expression = "a && (!b || c)";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        expResult.add('b');
        expResult.add('c');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void SameLetterCountsAsOneCharacter() {
        String expression = "a || !a";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void BigAndSmallLettersCountsAsDifferentCharacter() {
        String expression = "a || !A";
        List<Character> expResult = new ArrayList();
        expResult.add('a');
        expResult.add('A');
        List<Character> result = ExpressionConverter.convertExpressionToVariableLetters(expression);
        assertEquals(expResult, result);
    }
}

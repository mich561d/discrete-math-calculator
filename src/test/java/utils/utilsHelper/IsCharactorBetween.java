package utils.utilsHelper;

import org.junit.jupiter.api.Test;
import utils.UtilsHelper;
import static org.junit.jupiter.api.Assertions.*;

public class IsCharactorBetween {

    @Test
    public void LetterSmallAIsBetween97And122() {
        char c = 'a';
        int min = 97;
        int mix = 122;
        boolean result = UtilsHelper.isCharactorBetween(c, min, mix);
        assertTrue(result);
    }
    
    @Test
    public void LetterBigAIsNotBetween97And122() {
        char c = 'A';
        int min = 97;
        int mix = 122;
        boolean result = UtilsHelper.isCharactorBetween(c, min, mix);
        assertFalse(result);
    }
}

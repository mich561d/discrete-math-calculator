package utils.utilsHelper;

import org.junit.jupiter.api.Test;
import utils.UtilsHelper;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsHelperTest {

    @Test
    public void OneMustGiveTwo() {
        int numberOfVariables = 1;
        int expResult = 2;
        int result = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        assertEquals(expResult, result);
    }

    @Test
    public void TwoMustGiveFour() {
        int numberOfVariables = 2;
        int expResult = 4;
        int result = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        assertEquals(expResult, result);
    }

    @Test
    public void FourMustGiveSixteen() {
        int numberOfVariables = 4;
        int expResult = 16;
        int result = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        assertEquals(expResult, result);
    }

    @Test
    public void FiveMustGiveThirtytwo() {
        int numberOfVariables = 5;
        int expResult = 32;
        int result = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        assertEquals(expResult, result);
    }

    @Test
    public void SixMustGiveSixtyfour() {
        int numberOfVariables = 6;
        int expResult = 64;
        int result = UtilsHelper.getUniqueRowsFromNumberOfVariables(numberOfVariables);
        assertEquals(expResult, result);
    }
}

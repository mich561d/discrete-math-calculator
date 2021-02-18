package utils;

import java.util.ArrayList;
import java.util.List;
import utils.enums.ExpressionTypes;

public class HardcodedRows {

    public static List<List<ExpressionTypes>> variablesToRows(int numberOfVariables) {
        switch (numberOfVariables) {
            case 1:
                return OneVariableTwoRows();
            case 2:
                return TwoVariablesFourRows();
            case 3:
                return ThreeVariablesEightRows();
            case 4:
                return FourVariablesSixteenRows();
            case 5:
                return FiveVariablesThirthytwoRows();
            default:
                throw new IllegalArgumentException("To many variables..");
        }
    }

    private static List<ExpressionTypes> createRow(Boolean[] values) {
        List<ExpressionTypes> row = new ArrayList();
        for (Boolean value : values) {
            row.add(value ? ExpressionTypes.TRUE : ExpressionTypes.FALSE);
        }
        row.add(ExpressionTypes.UNKNOWN);
        return row;
    }

    private static List<List<ExpressionTypes>> OneVariableTwoRows() {
        List<List<ExpressionTypes>> rows = new ArrayList();

        Boolean[] row01 = {true};
        Boolean[] row02 = {false};
        rows.add(createRow(row01));
        rows.add(createRow(row02));

        return rows;
    }

    private static List<List<ExpressionTypes>> TwoVariablesFourRows() {
        List<List<ExpressionTypes>> rows = new ArrayList();

        Boolean[] row01 = {true, true};
        Boolean[] row02 = {true, false};
        Boolean[] row03 = {false, true};
        Boolean[] row04 = {false, false};
        rows.add(createRow(row01));
        rows.add(createRow(row02));
        rows.add(createRow(row03));
        rows.add(createRow(row04));

        return rows;
    }

    private static List<List<ExpressionTypes>> ThreeVariablesEightRows() {
        List<List<ExpressionTypes>> rows = new ArrayList();

        Boolean[] row01 = {true, true, true};
        Boolean[] row02 = {true, true, false};
        Boolean[] row03 = {true, false, true};
        Boolean[] row04 = {true, false, false};
        Boolean[] row05 = {false, true, true};
        Boolean[] row06 = {false, true, false};
        Boolean[] row07 = {false, false, true};
        Boolean[] row08 = {false, false, false};
        rows.add(createRow(row01));
        rows.add(createRow(row02));
        rows.add(createRow(row03));
        rows.add(createRow(row04));
        rows.add(createRow(row05));
        rows.add(createRow(row06));
        rows.add(createRow(row07));
        rows.add(createRow(row08));

        return rows;
    }

    private static List<List<ExpressionTypes>> FourVariablesSixteenRows() {
        List<List<ExpressionTypes>> rows = new ArrayList();

        Boolean[] row01 = {true, true, true, true};
        Boolean[] row02 = {true, true, true, false};
        Boolean[] row03 = {true, true, false, true};
        Boolean[] row04 = {true, true, false, false};
        Boolean[] row05 = {true, false, true, true};
        Boolean[] row06 = {true, false, true, false};
        Boolean[] row07 = {true, false, false, true};
        Boolean[] row08 = {true, false, false, false};
        Boolean[] row09 = {false, true, true, true};
        Boolean[] row10 = {false, true, true, false};
        Boolean[] row11 = {false, true, false, true};
        Boolean[] row12 = {false, true, false, false};
        Boolean[] row13 = {false, false, true, true};
        Boolean[] row14 = {false, false, true, false};
        Boolean[] row15 = {false, false, false, true};
        Boolean[] row16 = {false, false, false, false};
        rows.add(createRow(row01));
        rows.add(createRow(row02));
        rows.add(createRow(row03));
        rows.add(createRow(row04));
        rows.add(createRow(row05));
        rows.add(createRow(row06));
        rows.add(createRow(row07));
        rows.add(createRow(row08));
        rows.add(createRow(row09));
        rows.add(createRow(row10));
        rows.add(createRow(row11));
        rows.add(createRow(row12));
        rows.add(createRow(row13));
        rows.add(createRow(row14));
        rows.add(createRow(row15));
        rows.add(createRow(row16));

        return rows;
    }

    private static List<List<ExpressionTypes>> FiveVariablesThirthytwoRows() {
        List<List<ExpressionTypes>> rows = new ArrayList();

        Boolean[] row01 = {true, true, true, true, true};
        Boolean[] row02 = {true, true, true, true, false};
        Boolean[] row03 = {true, true, true, false, true};
        Boolean[] row04 = {true, true, true, false, false};
        Boolean[] row05 = {true, true, false, true, true};
        Boolean[] row06 = {true, true, false, true, false};
        Boolean[] row07 = {true, true, false, false, true};
        Boolean[] row08 = {true, true, false, false, false};
        Boolean[] row09 = {true, false, true, true, true};
        Boolean[] row10 = {true, false, true, true, false};
        Boolean[] row11 = {true, false, true, false, true};
        Boolean[] row12 = {true, false, true, false, false};
        Boolean[] row13 = {true, false, false, true, true};
        Boolean[] row14 = {true, false, false, true, false};
        Boolean[] row15 = {true, false, false, false, true};
        Boolean[] row16 = {true, false, false, false, false};
        Boolean[] row17 = {false, true, true, true, true};
        Boolean[] row18 = {false, true, true, true, false};
        Boolean[] row19 = {false, true, true, false, true};
        Boolean[] row20 = {false, true, true, false, false};
        Boolean[] row21 = {false, true, false, true, true};
        Boolean[] row22 = {false, true, false, true, false};
        Boolean[] row23 = {false, true, false, false, true};
        Boolean[] row24 = {false, true, false, false, false};
        Boolean[] row25 = {false, false, true, true, true};
        Boolean[] row26 = {false, false, true, true, false};
        Boolean[] row27 = {false, false, true, false, true};
        Boolean[] row28 = {false, false, true, false, false};
        Boolean[] row29 = {false, false, false, true, true};
        Boolean[] row30 = {false, false, false, true, false};
        Boolean[] row31 = {false, false, false, false, true};
        Boolean[] row32 = {false, false, false, false, false};
        rows.add(createRow(row01));
        rows.add(createRow(row02));
        rows.add(createRow(row03));
        rows.add(createRow(row04));
        rows.add(createRow(row05));
        rows.add(createRow(row06));
        rows.add(createRow(row07));
        rows.add(createRow(row08));
        rows.add(createRow(row09));
        rows.add(createRow(row10));
        rows.add(createRow(row11));
        rows.add(createRow(row12));
        rows.add(createRow(row13));
        rows.add(createRow(row14));
        rows.add(createRow(row15));
        rows.add(createRow(row16));
        rows.add(createRow(row17));
        rows.add(createRow(row18));
        rows.add(createRow(row19));
        rows.add(createRow(row20));
        rows.add(createRow(row21));
        rows.add(createRow(row22));
        rows.add(createRow(row23));
        rows.add(createRow(row24));
        rows.add(createRow(row25));
        rows.add(createRow(row26));
        rows.add(createRow(row27));
        rows.add(createRow(row28));
        rows.add(createRow(row29));
        rows.add(createRow(row30));
        rows.add(createRow(row31));
        rows.add(createRow(row32));

        return rows;
    }
}

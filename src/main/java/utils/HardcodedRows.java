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
}

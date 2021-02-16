package utils.DTOs;

import java.util.List;
import utils.enums.ExpressionTypes;

public class CalculationDTO {

    private final String EXPRESSION;
    private final List<String> HEADERS;
    private final List<List<ExpressionTypes>> ROWS;

    public CalculationDTO(String expression, List<String> headers, List<List<ExpressionTypes>> rows) {
        this.EXPRESSION = expression;
        this.HEADERS = headers;
        this.ROWS = rows;
    }

    public String getExpression() {
        return EXPRESSION;
    }

    public List<String> getHeaders() {
        return HEADERS;
    }

    public List<List<ExpressionTypes>> getRows() {
        return ROWS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Result ---\n");
        sb.append(String.format("Expression: %s\n", EXPRESSION));
        HEADERS.forEach(header -> sb.append(String.format(" %s |", header)));
        sb.append("\n");
        ROWS.forEach(row -> {
            row.forEach(type -> sb.append(String.format(" %s |", type)));
            sb.append("\n");
        });
        sb.append("\n");
        sb.append("--------------");
        return sb.toString();
    }

}

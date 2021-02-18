package utils.DTOs;

public class ExpressionRuleDTO {
    
    private final String TITLE;
    private final String DESCRIPTION;
    private final String EXAMPLE;

    public ExpressionRuleDTO(String title, String description, String example) {
        this.TITLE = title;
        this.DESCRIPTION = description;
        this.EXAMPLE = example;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getDescription() {
        return DESCRIPTION;
    }
    
    public String getExample() {
        return EXAMPLE;
    }

    @Override
    public String toString() {
        return TITLE + ": " + DESCRIPTION + " (" + EXAMPLE + ")";
    }
    
    
}

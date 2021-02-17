package utils.DTOs;

public class ExpressionRuleDTO {
    
    private final String TITLE;
    private final String DESCRIPTION;

    public ExpressionRuleDTO(String title, String description) {
        this.TITLE = title;
        this.DESCRIPTION = description;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String toString() {
        return TITLE + ": " + DESCRIPTION;
    }
    
    
}

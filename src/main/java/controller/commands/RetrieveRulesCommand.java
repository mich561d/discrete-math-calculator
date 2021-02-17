package controller.commands;

import controller.Command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DTOs.ExpressionRuleDTO;
import static utils.DiscreteMath.getSymbols;

public class RetrieveRulesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<ExpressionRuleDTO> result = getSymbols();
        request.getSession().setAttribute("expression-rules", result);
        return "index";
    }
}

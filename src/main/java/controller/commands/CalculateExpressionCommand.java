package controller.commands;

import controller.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DTOs.CalculationDTO;
import static utils.DiscreteMath.calculateExpression;

public class CalculateExpressionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String expression = request.getParameter("discrete-math-expression");
        CalculationDTO result = calculateExpression(expression);
        request.getSession().setAttribute("discrete-math-result", result);
        return "index";
    }
}

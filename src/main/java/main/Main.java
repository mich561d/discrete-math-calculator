package main;

import utils.DTOs.CalculationDTO;
import utils.DiscreteMath;
import static utils.DiscreteMath.calculateExpression;
import static utils.UserInteractor.getAnswer;
import static utils.UserInteractor.showSymbols;

public class Main {

    public static void main(String[] args) {
        showSymbols(DiscreteMath.getSymbols());

        String expression = getAnswer("Write an expression..");
        CalculationDTO result = calculateExpression(expression);
        System.out.println(result.toString());
    }
}

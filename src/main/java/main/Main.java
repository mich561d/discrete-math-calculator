package main;

import utils.DTOs.CalculationDTO;
import utils.DiscreteMath;
import utils.UserInteractor;

public class Main {
    
    public static void main(String[] args) {
        UserInteractor.showSymbols(DiscreteMath.getSymbols());
        
        String expression = UserInteractor.getAnswer("Write an expression..");
        CalculationDTO result = DiscreteMath.calculateExpression(expression);
        System.out.println(result.toString());
    }
}

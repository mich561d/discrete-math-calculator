package utils;

import java.util.List;
import java.util.Scanner;
import utils.DTOs.ExpressionRuleDTO;

public class UserInteractor {
    
    private final static Scanner SCAN = new Scanner(System.in);
    
    public static String getAnswer(String question) {
        System.out.println(question);
        String answer = SCAN.nextLine();
        return answer;
    }
    
    public static void showSymbols(List<ExpressionRuleDTO> symbols) {
        System.out.println("--- Usable symbols ---");
        symbols.forEach(line -> System.out.println(line));
        System.out.println("----------------------");
    }
}

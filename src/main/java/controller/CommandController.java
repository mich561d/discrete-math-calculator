package controller;

import controller.commands.*;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public abstract class CommandController {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("CalculateExpression", new CalculateExpressionCommand());
        commands.put("RetrieveRules", new RetrieveRulesCommand());
        commands.put("GoToIndex", new GoToIndexCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

}

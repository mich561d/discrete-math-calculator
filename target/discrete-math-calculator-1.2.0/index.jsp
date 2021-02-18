<%@page import="utils.DTOs.ExpressionRuleDTO"%>
<%@page import="utils.enums.ExpressionTypes"%>
<%@page import="java.util.List"%>
<%@page import="utils.DTOs.CalculationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Discrete Math Calculator</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="card my-3">
                        <div class="card-body">
                            <h5 class="card-title">Description</h5>
                            <p class="card-text">Welcome to my discrete math calculator! This system is created to evaluate discrete math expression and show a result table for that expression. This is still a work in progress system and therefore errors can occur. There is currently a limit to placeholders in the expression - You can use up to five placeholders (placeholder = variable or letter)</p>
                            <p class="card-text">Some examples of discrete math expressions: <code>'!a'</code>, <code>'a && b'</code>, <code>'a || !b'</code>, <code>'a && (!b || !c)'</code> and so on. You can use any letter both lowercase and uppercase, you can read the rules of which statements you can use in current version of this discrete math calculator.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <div class="row">
                        <div class="col-12">
                            <form name="CalculateExpression" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="CalculateExpression">
                                <label for="discrete-math-expression" class="form-label">Discrete Math Expression:</label>
                                <input type="text" class="form-control" id="discrete-math-expression" name="discrete-math-expression" placeholder="Write an expression...">
                                <button type="submit" class="btn btn-primary mt-1">Calculate</button>
                            </form>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <% if (request.getSession().getAttribute("expression-rules") != null) {%>
                            <% List<ExpressionRuleDTO> rules = (List<ExpressionRuleDTO>) request.getSession().getAttribute("expression-rules");%>
                            <div class="row">
                                <div class="col-4">
                                    <div class="list-group" id="list-tab" role="tablist">
                                        <% for (int i = 0; i < rules.size(); i++) {%>
                                        <% if (i == 0) {%>
                                        <a class="list-group-item list-group-item-action active" id="list-<%=rules.get(i).getTitle()%>-list" data-bs-toggle="list" href="#list-<%=rules.get(i).getTitle()%>" role="tab" aria-controls="home"><%=rules.get(i).getTitle()%></a>
                                        <%} else {%>
                                        <a class="list-group-item list-group-item-action" id="list-<%=rules.get(i).getTitle()%>-list" data-bs-toggle="list" href="#list-<%=rules.get(i).getTitle()%>" role="tab" aria-controls="profile"><%=rules.get(i).getTitle()%></a>
                                        <%}%>
                                        <%}%>
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="tab-content" id="nav-tabContent">
                                        <% for (int i = 0; i < rules.size(); i++) {%>
                                        <% if (i == 0) {%>
                                        <div class="tab-pane fade show active" id="list-<%=rules.get(i).getTitle()%>" role="tabpanel" aria-labelledby="list-<%=rules.get(i).getTitle()%>-list">
                                            <div class="card">
                                                <div class="card-body">
                                                    <p class="card-text"><%=rules.get(i).getDescription()%></p>
                                                </div>
                                            </div>
                                        </div>
                                        <%} else {%>
                                        <div class="tab-pane fade" id="list-<%=rules.get(i).getTitle()%>" role="tabpanel" aria-labelledby="list-<%=rules.get(i).getTitle()%>-list">
                                            <div class="card">
                                                <div class="card-body">
                                                    <p class="card-text"><%=rules.get(i).getDescription()%></p>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                        <%}%>
                                    </div>
                                </div>
                            </div>
                            <% } else {%>
                            <form name="RetrieveRules" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="RetrieveRules">
                                <button type="submit" class="btn btn-primary btn-sm">Retrieve rules</button>
                            </form>
                            <% }%>
                        </div>
                    </div>
                </div>
                <div class="col-8">
                    <% if (request.getSession().getAttribute("discrete-math-result") != null) {%>
                    <% CalculationDTO result = (CalculationDTO) request.getSession().getAttribute("discrete-math-result");%>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <% for (String header : result.getHeaders()) {%>
                                <th scope="col"><%=header%></th>
                                    <%}%>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (List<ExpressionTypes> row : result.getRows()) {%>
                            <tr>
                                <% for (ExpressionTypes expressionType : row) {%>
                                <% if (expressionType.equals(ExpressionTypes.TRUE)) {%>
                                <td class="text-success">
                                    <% } else {%>
                                <td class="text-danger">
                                    <% }%>
                                    <%=expressionType%></td>
                                    <%}%>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <% } else {%>
                    <p>1. Write an expression</p>
                    <p>2. Press 'Calculate'</p>
                    <p>3. Result will show here</p>
                    <% }%>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>


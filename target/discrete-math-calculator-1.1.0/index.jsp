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
                    <p>Description</p>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <div class="row">
                        <div class="col-12">
                            <form name="CalculateExpression" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="CalculateExpression">
                                <label for="discrete-math-expression" class="form-label">Discrete Math Expression:</label>
                                <input type="text" class="form-control" id="discrete-math-expression" name="discrete-math-expression" placeholder="Write an expression..">
                                <button type="submit" class="btn btn-primary mt-1">Calculate</button>
                            </form>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <p>Rules</p>
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


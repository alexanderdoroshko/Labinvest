<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        span.error {
            color: red;
        }
    </style>
</head>

<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/sensor/pagination?pageNumber=1&pageSize=4&sortField=name&sortDirection=ASC"); %>
</sec:authorize>
<div class="container">
    <div class="w3-display-middle">
        <form method="POST" action="/login">
            <h2>Вход в систему</h2>
            <div>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control w-28" id="username" placeholder="Enter username"
                           name="username"
                           required>
                    <span class="error">${emailError}</span>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control w-28" id="pwd" placeholder="Enter password"
                           name="password"
                           required>
                    <span class="error">${passwordError}</span>
                </div>
                <button type="submit" class="btn btn-primary">Log In</button>
                <h4><a href="/registration">Зарегистрироваться</a></h4>
            </div>
        </form>
    </div>
</div>
</body>
</html>



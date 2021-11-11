<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Авторизация</title>
</head>
<body>
<c:if test="${not empty errorMessge}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
            ${errorMessge}
    </div>
</c:if>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Авторизация
            </div>
            <div class="card-body">
                <form name='login' action="<c:url value='/login'/>" method='POST'>
                    <div class="form-group">
                        <label>Имя пользователя:</label>
                        <input type="text" class="form-control" name='username'>
                    </div>
                    <div class="form-group">
                        <label>Пароль:</label>
                        <input type="password" class="form-control" name='password'>
                    </div>
                    <button type="submit" class="btn btn-primary pull-left" name="submit">Войти</button>
                    <button type="submit" class="btn btn-light pull-right m1-2" formaction="<c:url value='/reg'/>"
                            formmethod="GET" formnovalidate>Регистрация</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
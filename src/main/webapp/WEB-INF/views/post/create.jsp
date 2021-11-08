<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Создание темы</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <h4>Форум job4j</h4>
    </div>

    <div class="row justify-content-end">
        <ul class="nav">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/index"/>">Форум</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/post/create"/>">Новая тема</a></li>
            <li class="nav-item"><a class="nav-link" href="#"><c:out value="${user}"/></a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">Выход</a></li>
        </ul>
    </div>

    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header text-center">
                <strong>Создание темы</strong>
            </div>
        </div>
        <div class="card-body">
            <form action="<c:url value="/post/save"/>" method="POST">
                <div class="form-group">
                    <label for="name">Название:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="description">Описание:</label>
                    <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-dark">Сохранить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
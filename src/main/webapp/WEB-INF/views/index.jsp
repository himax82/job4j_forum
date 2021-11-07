<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Форум job4j</title>
</head>
<body>
<div class="container mt-3">
    <div class="row justify-content-center">
        <h4>Форум job4j</h4>
    </div>

    <div class="row justify-content-end">
        <ul class="nav">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/index"/>">Форум</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/post/edit"/>">Новая тема</a></li>
            <li class="nav-item"><a class="nav-link" href="#"><c:out value="${user.username}"/></a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">Выход</a></li>
        </ul>
    </div>

    <div class="row">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col" style="width: 3%"></th>
                <th scope="col">Название</th>
                <th scope="col">Автор</th>
                <th scope="col">Ответов</th>
                <th scope="col">Текст</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                        <c:if test="${user != null && user.equals(post.author)}">
                            <a href='<c:url value="/post/edit?id=${post.id}"/>'>
                                <i class="fa fa-edit mr-3"></i>
                            </a>
                        </c:if>
                    </td>
                    <td>
                        <a href='<c:url value="/post?id=${post.id}"/>'><div class="h6"><c:out value="${post.name}"/></div></a>
                        <small>Автор <c:out value="${post.author.username}"/></small>
                    </td>
                    <td>
                        <div class="h6"><c:out value="${post.author.username}"/></div>
                    </td>
                    <td>
                        <c:out value="${post.comments.size()}"/> Ответов
                    </td>
                    <td>
                        <c:out value="${post.description}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
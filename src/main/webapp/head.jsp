<%--
  head.jsp to include in each JSP file.
  User: reyesmac
  Date: 4/12/23
  Time: 2:39 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- establishes JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- creates dynamic page title from a pageTitle variable in request scope --%>
<c:set var="title" value='${requestScope["pageTitle"]}' />

<head>
    <%-- meta --%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- title --%>
    <title><c:out value="${title}" /></title>
    <%-- bootstrap css --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <%-- bootstrap js --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%-- css file --%>
    <link href="css/custom.css" rel="stylesheet" type="text/css">
    <%-- favicon --%>
    <link href="${pageContext.request.contextPath}/images/favicon-32x32.png" rel="icon" type="image/x-icon">
</head>


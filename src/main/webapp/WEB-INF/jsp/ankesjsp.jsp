<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Anket Listesi</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a, button {
            text-decoration: none;
            padding: 5px 10px;
            margin: 5px;
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        a {
            background-color: #2196F3;
        }
        button:hover, a:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h1>Anket Listesi</h1>
<table>
    <thead>
    <tr>
        <th>Anke Adı</th>
        <th>Anke Soyadı</th>
        <th>Anke Yaşı</th>
        <th>Detay</th>
        <th>Sil</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ankeList}" var="anke">
        <tr>
            <td>${anke.name}</td>
            <td>${anke.surname}</td>
            <td>${anke.age}</td>
            <td><a href="editanke/${anke.id}">Detay</a></td>
            <td>
                <form method="POST" action="deleteanke/${anke.id}" onsubmit="return confirm('Bu ankeyi silmek istediğinizden emin misiniz?');">
                    <button type="submit">Sil</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/newanke">Yeni Anke Ekle</a>
</body>
</html>

<%--<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Project Listesi</h1>
<table>
    <thead>
    <th><b>Project Code</b></th>
    <th><b>Project Name</b></th>
    </thead>
    <c:forEach items="${projeListesi}" var="project">
        <tr>
            <td>${project.projectCode}</td>
            <td>${project.projectName}</td>
            <td><a href="editproject/${project.id}">Detay</a></td>
            <td>
                <form method="POST" action="deleteproject/${project.id}"
                      onsubmit="return confirm('Are you sure you want to delete this project?');">
                    <button type="submit" >Delete</button></form></td>
        </tr>
    </c:forEach>

</table>

<a href="/newproject">Yeni Proje Ekle</a>
</body>
</html>--%>

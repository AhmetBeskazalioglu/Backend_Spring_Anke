<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Anke Kayıt Sayfası</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        table {
            width: 50%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        td {
            padding: 10px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .form-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Anke Kayıt Sayfası</h1>
    <form:form method="POST" action="/addnewanke">
        <table>
            <tr>
                <td>Anke Adı:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Anke Soyadı:</td>
                <td><form:input path="surname" /></td>
            </tr>
            <tr>
                <td>Anke Yaşı:</td>
                <td><form:input path="age" /></td>
            <tr>
                <td colspan="2" style="text-align: right;">
                    <input type="submit" value="Kaydet" />
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

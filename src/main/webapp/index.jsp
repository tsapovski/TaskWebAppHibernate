<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pets</title>
</head>
<body>
<h2>Pets List</h2>
<p><a href='<c:url value="/create" />'>Add new pet</a></p><br>
<table>
    <tr>
        <th>Type</th>
        <th>name</th>
        <th>age</th>
        <th>color</th>
        <th>owner</th>
    </tr>
    <c:forEach var="pets" items="${pets}">
        <tr>
            <td>${pets.typePet}</td>
            <td>${pets.name}</td>
            <td>${pets.age}</td>
            <td>${pets.color}</td>
            <td>${pets.ownerStatus}</td>
            <td>
                <a href='<c:url value="/edit?id=${pets.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${pets.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
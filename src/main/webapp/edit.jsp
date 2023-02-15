<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit pet</title>
</head>
<body>
<h3>Edit pet</h3>
<form method="post">
  <input type="hidden" value="${pets.id}" name="id"/><br>
  <label>Type</label><br>
  <input Name="typePet" value="${pets.typePet}"/><br>
  <label>Name</label><br>
  <input name="name" value="${pets.name}" /><br>
  <label>Age</label><br>
  <input name="age" value="${pets.age}" type="number"/><br>
  <label>Color</label><br>
  <input name="color" value="${pets.color}" /><br>
  <label>Owner</label><br>
  <input name="ownerStatus" value="${pets.ownerStatus}" /><br>
  <input type="submit" value="Send" />
</form>
</body>
</html>
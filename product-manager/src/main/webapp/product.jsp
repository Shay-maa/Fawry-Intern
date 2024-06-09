<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Manager - Products</title>
</head>
<body>
<h1>Products</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Delete</th>
        <th>Update</th>

    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productDesc}</td>
            <td>
            <form action="product" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="${product.productId}">
                <input type="submit" value="Delete">
            </form>
            </td>
            <td>
                <form action="product" method="post" style="display:inline;">
                <input type="hidden" name="id" value="${product.productId}">
                    <input type="hidden" name="action" value="edit">
                <input type="submit" value="Update">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>

<button><a href="index.jsp">Add new Product</a>
    </button>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Manager</title>
</head>
<body>
<h1>Add Product</h1>
<form action="product" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name"><br>
    Price: <input type="text" name="price"><br>
    description: <input type="text" name="desc"><br>

    <input type="submit" value="Add Product">
</form>

<h1>Products</h1>
<a href="product?action=get">List Products</a>
</body>
</html>

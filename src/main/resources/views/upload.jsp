<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Upload PAGE</title>
</head>

<body>
<h1>Welcome come to Spring MVC world!</h1>
<div class="upload">
    <form action="upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>
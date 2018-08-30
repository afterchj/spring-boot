<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Converter PAGE</title>
</head>
<script type="text/javascript" src="static/jquery.min.js"></script>
<script type="text/javascript">
    function req() {
        $.ajax({
            url: "convert",
            data: "101-chj",
            type: "post",
            contentType: "application/x-wisely",
            success: function (data) {
                $("#resp").html(data);
            }
        })

    }
</script>
<body>
<h1>Welcome come to Spring MVC world!</h1>
<input type="button" value="test" onclick="req()">
<div id="resp"></div>
</body>
</html>
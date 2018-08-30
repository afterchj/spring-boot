<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>SSE page</title>
</head>
<script type="text/javascript" src="static/jquery.js"></script>

<body>
<h1>Welcome come to Spring MVC world!</h1>

<script type="text/javascript">

    deferred();

    function deferred() {
        $.get('defer', function (data) {
            console.log("show:" + data);
            deferred();
        })
    }
</script>
</body>
</html>
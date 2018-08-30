<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>SSE page</title>
</head>
<script type="text/javascript" src="static/jquery.js"></script>
<script type="text/javascript">

    if (!!window.EventSource) {
        var source = new EventSource("push");
        var s = "";
        source.addEventListener("message",function (e) {
            s+=e.data+"<br>";
            $("#msgFromPush").html(s);
        });
        source.addEventListener("open", function (e) {
            console.log("连接关闭");
        }, false);

        source.addEventListener("error", function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            }
            else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("浏览器不支持SSE");
    }
</script>
<body>
<h1>Welcome come to Spring MVC world!</h1>
<div id="msgFromPush"></div>
</body>
</html>
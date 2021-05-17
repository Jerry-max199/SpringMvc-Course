<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2021/5/14
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc项目</p>
    <p><a href="test/some.do">发起some，do的请求</a> </p>
    <form action="test/other.do" method="post" >
        <input type="submit" value="post请求">
    </form>
    <p><a href="test/fist.do">发起some，do的请求</a> </p>
</body>
</html>

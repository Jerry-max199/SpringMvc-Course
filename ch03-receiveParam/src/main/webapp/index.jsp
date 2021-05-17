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
    <p>提交参数给Controller</p>
    <form action="receiveParam.do" method="post" >
        姓名：<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="post请求">
    </form>
    <p>参数名和形参名不一样</p>
    <form action="receiveproperty.do" method="post">
        姓名：<input type="text" name="rname">
        年龄:<input type="text" name="rage">
        <input type="submit" value="提交参数">
    </form>
    <p>用对象接收请求参数</p>
    <form action="receiveObject.do" method="post">
        姓名：<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>

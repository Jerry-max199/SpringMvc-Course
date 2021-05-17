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
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    //url:"returnVoid-ajax.do",
                    //url:"returnStudent.do",
                   url:"returnlist.do",
                    /*url:"returnString.do",*/
                   /* data:{
                        name:"张三",
                        age:30
                    },*/
                    type:"post",
                    //dataType:"json",
                    success:function (resp) {
                        //resp从服务器端返回的json格式的字符串
                        //jquery会把字符串转换为json对象
                        /*alert(resp.name+""+resp.age);*/
                        $.each(resp,function (i,n) {
                            alert(n.name+n.age);
                        })
                       /*alert(resp);*/
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器返回String表示视图名称</p>
    <form action="returnString-view.do" method="post" >
        姓名：<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="post请求">
    </form>
    <button id="btn">发起了ajax请求</button>
</body>
</html>

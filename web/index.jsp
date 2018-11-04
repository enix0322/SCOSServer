<%--
  Created by IntelliJ IDEA.
  User: FUTURE
  Date: 2018/10/31
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
用户名：<input type="text" id="name"/><br/>
密码：<input type="password" id="userPwd"/><br/>
<form method = "post" action="LoginValidator">
    <input type="button" value="提交" id="sender"/>
</form>

<div id="messageDiv"></div>

<script>
    ('#sender').click(function() {
        var userName = document.getElementById('name').value;
        var userPwd = document.getElementById('userPwd').value;
        var user = {userName: userName, userPwd: userPwd};
        var url = "LoginValidator";
        $.post(url, JSON.stringify(user), function (data) {
            console.log(data);
            $("#messageDiv").html(data);
            var json = JSON.parse(data);
            alert(json.message);
        });
    })
</script>
</body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%   
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MyBatis 整合  Spring 3.0.5</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
          <h3>MyBatis 3.0.4  整合  Spring 3.0.5</h3>
        <a href="account/addinit.mvc">添加</a><br/>
  </body>
</html>

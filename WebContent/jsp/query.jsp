<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


  <head>
    <title>MyBatis 整合  Spring 3.0.5</title>
   
  </head>

  <body>

		<!-- 这里写入当前页面的jsp代码 -->
		<h3>add account</h3>
		
		<form:form name="query" action="/myBatis_Spring/account/showDetail.mvc" >
					username:<input type="text" name="username" />
					<input type="submit" value="Query" />
		</form:form> 
  </body>
</html>

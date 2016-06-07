<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


  <head>
   <title>MyBatis 整合  Spring 3.0.5</title>
   <script>
       function onDelete(){
    	   var form = document.getElementById("detailForm");
    	   form.action = "/myBatis_Spring/account/delete.mvc";
    	   form.submit;
       }
   </script>
   
  </head>

  <body>

		<!-- 这里写入当前页面的jsp代码 -->
		<h3>add account</h3>
		<form:form name="update" id = "detailForm" action="/myBatis_Spring/account/update.mvc">
			<table>
				<tr>
					<td>id:</td>
					<td>username:</td>
					<td>password:</td>
					<td>email:</td>
					<td>address:</td>
				</tr>
				<tr>
					<td><input type = "text" name = "id" value = "${account.id}"/></td>
					<td><input type = "text" name = "username" value = "${account.username}"/></td>
					<td><input type = "text" name = "password" value = "${account.password}"/></td>
					<td><input type = "text" name = "email" value = "${account.email}"/></td>
					<td><input type = "text" name = "address" value = "${account.address}"/></td>
				</tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
				<td colspan="2"><input type="submit" id = "delete" value="Delete" onClick = "onDelete()"/></td>
			</table>
			</form:form>
  </body>
</html>

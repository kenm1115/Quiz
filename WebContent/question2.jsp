<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問2</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="ScoreCalculate2" method="post">
<div>
<c:out value="${requestScope.message}"></c:out>
</div>
<h1>問2</h1>
<br>
<table>
<tr>
<td>84÷7=</td>
<td><input type="text" name="q2" size="10"></td>
</tr>
</table>
<input type="submit" value="回答">
</form>
<a href="question1.jsp">戻る</a>
</body>
</html>
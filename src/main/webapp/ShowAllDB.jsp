<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<% HashMap<String,String> myDb =(HashMap<String,String>)session.getAttribute("myList");
	for(String key: myDb.keySet()){
		out.print(key+" : "+myDb.get(key)+"<br>");
	}
%>
<hr>
<table style="border:solid;border-collapse:collapse">
<c:forEach var="li" items="${sessionScope.myList}" >
<tr>
<td style="border:solid">${li.key}</td>
<td style="border:solid">${li.value}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
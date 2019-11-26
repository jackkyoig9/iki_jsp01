<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] str={"01", "02", "03"};
%>
<ul>
<%
for(String s : str){
	out.println("<li>"+s+"</li>");
}
%>
</ul>
</body>
</html>
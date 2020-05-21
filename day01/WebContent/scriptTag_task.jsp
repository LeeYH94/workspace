<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<table border="0">
	<%
		for(int i=0; i<6; i++){
	%>
		<tr>
			<%
				for(int j=0; j<i; j++){
			%>
			<td>□</td>
			<%
				}
			%>
		</tr>
	<%
		}
	%>
	
	<%
		for(int i=5; i<11; i++){
	%>
		<tr>
			<%
				for(int j=0; j<10-i; j++){
			%>
			<td>□</td>
			<%
				}
			%>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>
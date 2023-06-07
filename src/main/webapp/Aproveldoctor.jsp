<%@page import="java.util.List"%>
<%@page import="dto.Doctor11"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Doctor11> list=(List<Doctor11>)request.getAttribute("list"); %>

<table border='1'>
<tr>
<th>Id</th>
<th> Name </th><th> mobile</th> <th> age</th><th>qulification</th> <th>specilization</th><th>status</th> <th>change status</th></tr>
<% for(Doctor11 s:list){%>
<tr>
<th><%=s.getId()%></th>
<th><%=s.getName()%></th>
<th><%=s.getPhone()%></th>
<th><%=s.getAge()%></th>
<th><%=s.getSpecilization() %></th>
<th><%=s.getQulification() %></th>
<th><%=s.isStutas()%></th>
<th><a href="changedoctorstatus?id=<%=s.getId()%>"><button>change status</button></a></th>
</tr>
<%} %>
</table>



</body>
</html>
 <%@page import="com.blazepizza.ProjectB.bean.Orders" %>
<%@page import="java.util.*" %>
<html>
 
<body>
<%ArrayList<Orders> al=(ArrayList<Orders>)request.getAttribute("aa"); %>
<table border="4">
<tr><th>Task </th><th>Description</th><th>Completed</th></tr>
<%for(Orders o:al)
{
%>
<tr><td><%=o.getTask() %></td><td><%=o.getDescription() %></td><td><%=o.getCompleted() %></td></tr>
<%} %>
</table> 
</body>
</html>
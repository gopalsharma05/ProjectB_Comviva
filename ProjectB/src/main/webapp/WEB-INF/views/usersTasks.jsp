 <%@page import="com.blazepizza.ProjectB.bean.Tasks" %>
<%@page import="java.util.*" %>
<html>
 
<body>
<%
ArrayList<Tasks> al=(ArrayList<Tasks>)request.getAttribute("aa");
%>
<table border="4">
<tr><th>Task </th><th>Description</th><th>Completed</th></tr>
<%
for(Tasks o:al)
{
%>
<tr><td><%=o.getTask() %></td><td><%=o.getDescription() %></td><td><%=o.getCompleted() %></td></tr>
<%} %>
</table> 
</body>
</html>
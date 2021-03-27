<html>

<body>
Here is the orders details of the logged in user.<br><br>

<%String username=(String)request.getAttribute("aaa");

%>

<form action ="addToUserCart">
enter username:   <input type="text" name="username" value="<%=username %>"/><br><br>
enter Task    <input type="text" name="task"/><br><br>
enter Task Description  <input type="text" name="description"/><br><br>
Task completed or not       <input type="text" name="completed"/><br><br>
<button type=submit>Add to Cart !</button>
</form>

<br><br>


 <form action ="myTasks">
  <input type = "hidden" name = "username" value="<%=username %>" />
<button type ="submit">getAllTasks</button> 
 <br>
<a href="/getAllTasks/<%= username %>"> See my tasks</a> 



</form>  

 

 
</body>
</html>
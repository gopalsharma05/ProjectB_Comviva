	<html>
	<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link rel="stylesheet" href="/css/registerstyle.css">  
</head>  
<body>  
<form action ="registered" method="POST">  
  <div class="container">  
  <center>  <h1> Signup for BlazePizza</h1> </center>  
  <hr>  
  <label> UserID </label>   
<input type="text" name="userid" placeholder= "userID" size="15" required />   
  <label> Firstname </label>   
<input type="text" name="firstName" placeholder= "Firstname" size="15" required />   
<label> Lastname: </label>    
<input type="text" name="lastName" placeholder="Lastname" size="15"required />     
<div>  
<label>   
Gender :  
</label> 
<input type="radio" value="Male" name="gender" checked > Male   
<input type="radio" value="Female" name="gender"> Female   
<input type="radio" value="Other" name="gender"> Other  
  
</div>  
<label>   
Phone :  
</label>    
<input type="text" name="phone" placeholder="phone no." size="10"/ required>  
<label> Street </label>    
<input type="text" name="street" placeholder="street" size="15"required />
<label> City </label>    
<input type="text" name="city" placeholder="city" size="15"required />    
<label> Pincode </label>    
<input type="text" name="pincode" placeholder="pincode" size="15"required />    
<label> State </label>    
<input type="text" name="state" placeholder="State" size="15"required />        
</textarea>  
 <label for="email"><b>Email</b></label>  
 <input type="text" placeholder="Enter Email" name="email" required/>  
  
    <label for="psw"><b>Password</b></label>  
    <input type="password" placeholder="Enter Password" name="password" required/>  
  
     
     <button type="submit" class="registerbtn">Register</button>    	
      
</form>  
</body>  
	</html>
package com.blazepizza.ProjectB.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blazepizza.ProjectB.bean.Orders;
import com.blazepizza.ProjectB.bean.ProfileBean;
import com.blazepizza.ProjectB.bean.UserCredential;
import com.blazepizza.ProjectB.service.CustomerService;
 

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cserv;

    @RequestMapping(value="/login")
    public ModelAndView meth1()
    {
    	
        return new ModelAndView("index");
    }
    
    
    
    @RequestMapping(value="/registered")
    public ModelAndView meth3(@ModelAttribute("customer")ProfileBean customer)
    {
    	System.out.println("in contoller");
    	
    	if(cserv.checkExistence(customer)==1)
    	{
    		
    		return new ModelAndView("alreadyExist");
    	}
    	else
    	{
    		cserv.userSignup(customer);
            return new ModelAndView("registered");
    	}
    	
    	
    
    
    }
    
    @RequestMapping(value="/signedin")
    public ModelAndView meth4(@ModelAttribute("uc")UserCredential uc,Model m)
    {
    	 if(cserv.isAuth(uc))
    	 {
//   		 System.out.println("User is found");
    		 
    		 m.addAttribute("aaa",uc.getUsername());
    		 return new ModelAndView("signsuccess");
    	 }
    	 else
    	 {
    		 String message="User is NOT found";
    		 ModelAndView mv=new ModelAndView();
    		 mv.addObject("message", message);
    		 mv.setViewName("index");
    		 return mv;	
    	 }
    }
    @RequestMapping(value="/signup")
    public ModelAndView meth2()
    {
        return new ModelAndView("Second");
    }
    
    @RequestMapping(value="/addToUserCart")
    public ModelAndView meth5(@ModelAttribute("ord")Orders ord)
    {
    	cserv.addToOrders(ord);
        return new ModelAndView("addedToCart");
        
    }
    
    @RequestMapping(value="/myTasks")
    public ModelAndView meth5(Model m,@RequestParam(name="username") String username)
    {
	
    	System.out.println(username+"is name of username");
    	m.addAttribute("aa", cserv.findAllTasks(username));
    	
        return new ModelAndView("usersTasks");
        
    }
    

}

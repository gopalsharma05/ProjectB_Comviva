package com.blazepizza.ProjectB.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView meth4(@ModelAttribute("uc")UserCredential uc)
    {
    	 if(cserv.isAuth(uc))
    	 {
    		 System.out.println("User is found");
    		 return new ModelAndView("signsuccess");
    	 }
    	 else
    	 {
    		 System.out.println("User is NOT found");
    		 return new ModelAndView("index");
    	 }
    }
    @RequestMapping(value="/signup")
    public ModelAndView meth2()
    {
    	
    	
        return new ModelAndView("Second");
    
    
    }
    
    


}

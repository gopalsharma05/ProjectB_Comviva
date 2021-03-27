package com.blazepizza.ProjectB.controller;

 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blazepizza.ProjectB.bean.Tasks;
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
    	
        return new ModelAndView("login");
    }
    
    
    
    @RequestMapping(value="/registered")
    public ModelAndView meth3(@ModelAttribute("customer")ProfileBean customer)
    {
    	
    	if(cserv.checkExistence(customer)==1)
    	{
    		ModelAndView mv = new ModelAndView();
    		mv.addObject("message", "*User is already register, please login");
    		mv.setViewName("signup");
    		return mv;
    	}
    	else
    	{
    		ModelAndView mv = new ModelAndView();
    		mv.addObject("message", "Please login to continue.");
    		cserv.userRegister(customer);
    		mv.setViewName("login");
    		return mv;
            
    	}
    	
    	
    
    
    }
    
    @RequestMapping(value="/home")
    public ModelAndView meth4(@ModelAttribute("uc")UserCredential uc,Model m)
    {
    	 if(cserv.isAuth(uc))
    	 {
////   		 System.out.println("User is found");
//    		 
//    		 m.addAttribute("aaa",uc.getUsername());
//    		 return new ModelAndView("signsuccess");
    		 ModelAndView mv = new ModelAndView();
    		 List<Tasks> tasks = cserv.findAllTasks(uc.getEmail());
    		 if(tasks != null) {
    			 m.addAttribute("tasks", tasks); 
    		 }
    		 System.out.println("Email from signup : " + uc.getEmail());
    		 m.addAttribute("aaa", uc.getEmail());
//    		 mv.addObject("email", uc.getEmail());
    	     return new ModelAndView("showTasks");
    		 
    		 
    	 }
    	 else
    	 {
    		 String message="Please register to login";
    		 ModelAndView mv=new ModelAndView();
    		 mv.addObject("message", message);
    		 mv.setViewName("login");	
    		 return mv;	
    	 }
    }
    @RequestMapping(value="/signup")
    public ModelAndView meth2()
    {
        return new ModelAndView("signup");
    }
    
    @RequestMapping("/addNewTask")
    public ModelAndView newTaskForm(Model m,@RequestParam(name="email") String email) {
    	m.addAttribute("email", email);
    	return new ModelAndView("addNewTask");
    }
    
    @RequestMapping("/newTask")
    public ModelAndView addNewTask(@ModelAttribute("nt")Tasks nt, Model m,@RequestParam(name="email") String email)
    {
//    	ModelAndView mv = new ModelAndView();
//    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//    	Date date = sdf.parse(nt.getTaskDate());
    	System.out.println("Email we extracted is : " + email);
    	
    	nt.setEmail(email);
    	cserv.addNewTask(nt);
    	
    	List<Tasks> tasks = cserv.findAllTasks(email);
		 if(tasks != null) {
			 System.out.println("printing id for all tasks");
			 for(Tasks t:tasks)
			 {
				 System.out.println(t.getTaskId());
			 }
			 m.addAttribute("tasks", tasks); 
		 }
    	return new ModelAndView("showTasks");
//    	System.out.println(nt);
//    	mv.setViewName("showTasks");
//    	return mv;
    }
    
    @RequestMapping("/updateTask")
    public ModelAndView updateTask(Model m,@ModelAttribute("ts")Tasks ts)
    {
//    	System.out.println("after click on update in show table");
//    	System.out.println(ts.getTaskId());
//    	System.out.println(ts.getEmail());
//    	System.out.println(ts.getTaskName());
//    	System.out.println(ts.getTaskDescription());
//    	System.out.println(ts.getTaskDate());
    	
    	m.addAttribute("mytask", ts); 
    	return new ModelAndView("updateTask");
    }
    
    @RequestMapping("/homeAfterUpdation")
    public ModelAndView homeAfterUpdation(Model m,@ModelAttribute("ts")Tasks ts)
    {
    	System.out.println("before");
    	 System.out.println("Email after click on update : " + ts.getEmail());
		 System.out.println("id after click on update : " + ts.getTaskId());
    	cserv.updateTheTask(ts); 
    	 
		 List<Tasks> tasks = cserv.findAllTasks(ts.getEmail());
		 System.out.println("after");
		 System.out.println("Email after click on update : " + ts.getEmail());
		 System.out.println("id after click on update : " + ts.getTaskId());
		 if(tasks != null) {
			 m.addAttribute("tasks", tasks); 
		 }
		
		 m.addAttribute("aaa", ts.getEmail());
//		 mv.addObject("email", uc.getEmail());
	     return new ModelAndView("showTasks");
    }
    
    @RequestMapping("/deleteTask")
    public ModelAndView deleteTask(Model m,@ModelAttribute("ts")Tasks ts)
    {
    	 cserv.deleteTask(ts);
    	 List<Tasks> tasks = cserv.findAllTasks(ts.getEmail());
//		 System.out.println("after");
//		 System.out.println("Email after click on update : " + ts.getEmail());
//		 System.out.println("id after click on update : " + ts.getTaskId());
		 if(tasks != null) {
			 m.addAttribute("tasks", tasks); 
		 }
		
		 m.addAttribute("aaa", ts.getEmail());
//		 mv.addObject("email", uc.getEmail());
	     return new ModelAndView("showTasks");
    }
    
    
//    @RequestMapping(value="/addToUserCart")
//    public ModelAndView meth5(@ModelAttribute("ord")Orders ord)
//    {
//    	cserv.addToOrders(ord);
//        return new ModelAndView("addedToCart");
//        
//    }
    
//    @RequestMapping(value="/myTasks")
//    public ModelAndView meth5(Model m,@RequestParam(name="username") String username)
//    {
//	
//    	System.out.println(username+"is name of username");
//    	m.addAttribute("aa", cserv.findAllTasks(username));
//    	
//        return new ModelAndView("usersTasks");
//        
//    }
    
//    @GetMapping(value="/getAllTasks/{username}")
//    public ModelAndView getAllTasks(Model m,@PathVariable String username){
//        System.out.println("Username retrieved is  : " + username);
////        mv.addObject(cserv.findAllTasks(username));
////        mv.addObject("tasks", cserv.findAllTasks(username));
//        m.addAttribute("tasks", cserv.findAllTasks(username));
//        return new ModelAndView("showTasks");
//    }
}

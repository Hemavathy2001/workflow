package com.example.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.workflow.model.Job;
import com.example.workflow.model.User;
import com.example.workflow.repository.JobRepository;
import com.example.workflow.repository.UserRepository;
import com.example.workflow.service.CustomUserDetailsService;
import com.example.workflow.service.JobService;


 
@Controller
public class AppController {
    
    @Autowired
    @Qualifier("userService")
    private CustomUserDetailsService userService;
    
    @Autowired
    @Qualifier("jobservice")
    private JobService jobservice;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        
        return "signup";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
    	  
         userService.encodePassword(user);
         return "register_success";
    }
    
    @GetMapping("/menus")
    public String showMenu() {
    	
       return "menu_page";
    }
    
    @GetMapping("/redirect")
    public String showJobForm(Model model) {
        model.addAttribute("job", new Job());
         
        return "enter_job";
    }
    
    @PostMapping("/process_save")
    public String processSave(Job job) {
    	
    	jobservice.SaveJob(job);
         
        return "save_success";
    }
    
    @GetMapping("/jobs")
    public String viewJobPage(Model model) {
    	jobservice.Jobmodel(model);
        return "jobs";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
    	  userService.userModel(model);
               
        return "users";
    }
    
    @GetMapping("/accept/{job}")
    public String acceptButton(@PathVariable Job job) {
    	jobservice.accept(job);
    	jobservice.calculateStatus(job);
    	return "menu_page";
    	
    	
    }
    @GetMapping("/reject/{job}")
    public String rejectButton(@PathVariable Job job) {
    	jobservice.reject(job);
    	jobservice.calculateStatus(job);
    	jobservice.deletePreviousJob(job);
    	return "enter_job";
    }
          
}
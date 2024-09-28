package com.SwiggyUser.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SwiggyUser.entity.SwiggyUser;
import com.SwiggyUser.response.UserRegisterResponse;
import com.SwiggyUser.services.UserRegisterRequest;
import com.SwiggyUser.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
    @PostMapping("/reg")
	public String registerUserDetails(@RequestBody UserRegisterRequest request)
	{
    	
    	String response=userService.registeredUserDetails(request);
		return response;
    	
	}
     
    @GetMapping("/fetch/{email}")
    public UserRegisterResponse getUserDetails(@PathVariable("email") String eamil) {
    	//String email="mahi@gmail"; instead of writing here we use pathvariable anotation we hit that email with uri
    	//UserRegisterResponse response=userService.getUserDetails(email);
    	//return response
        return userService.getUserDetails(eamil);
    	
    }
    
    @GetMapping("fetch/all")
    public List<SwiggyUser> getAllUserDetails(){
    	
    	return userService.getAllUserDetails();
    }
    @PostMapping("/send")
    public String sendOrder() {
		return "Order make successfully";
    	
    }
}

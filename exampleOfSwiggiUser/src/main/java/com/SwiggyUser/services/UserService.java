package com.SwiggyUser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SwiggyUser.Repository.UserRepository;
import com.SwiggyUser.entity.SwiggyUser;
import com.SwiggyUser.response.UserRegisterResponse;

@Service
public class UserService {
	        
	  @Autowired    
	UserRepository userRepo;
	  
	  public String registeredUserDetails(UserRegisterRequest registerRequest) {
		  
		  
		  SwiggyUser user=new SwiggyUser();
		  user.setEmail(registerRequest.getEmail());
		  user.setName(registerRequest.getName());
		  user.setMobile(registerRequest.getMobile());
		  user.setPassword(registerRequest.getPassword());
		  
		  userRepo.save(user);
		  
		return "User registerd successfully";
		  
	  }
	  
	  public UserRegisterResponse getUserDetails(String email)
	  {
		  SwiggyUser user=userRepo.findById(email).get();
		  UserRegisterResponse response=new UserRegisterResponse();
		  response.setEmail(user.getEmail());
		  response.setMobile(user.getMobile());
		  response.setName(user.getName());
		  response.setPassword(user.getPassword());
		return response;
		  
	  }

	  
	  public List<SwiggyUser> getAllUserDetails(){
		  return userRepo.findAll();
	  }
}

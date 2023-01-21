package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IUser;
import dao.UserImpl;
import model.User;


@RestController
public class UserController {

	@Autowired
	IUser User;
	UserImpl userImpl;
	@PostMapping("/userlogin")
    public String login(@RequestBody User user) {      
		//String result = userServices.Login(userName, userPassword);
		return userImpl.Login(user);
        
        }
}

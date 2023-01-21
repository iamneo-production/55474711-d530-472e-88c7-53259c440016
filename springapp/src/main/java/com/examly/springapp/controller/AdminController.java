package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.AdminImpl;
import dao.IAdmin;
import model.Admin;




@RestController
public class AdminController {

	@Autowired
	IAdmin Admin;
	AdminImpl adminImpl;
	@PostMapping("/adminlogin")
    public String login(@RequestBody Admin admin) {      
		return adminImpl.Login(admin);        
        }
}


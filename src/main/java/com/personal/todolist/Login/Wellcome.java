package com.personal.todolist.Login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("name")
public class Wellcome {

	
	

	@RequestMapping("/")
	
	public String main(ModelMap model) {
		model.put("name", getname());
	
		return "wellcome";
	}

	
	public String getname() {
		
	Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}

}

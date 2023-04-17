package com.personal.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Sayhello {
	
	@RequestMapping("saying-hello=-jsp")
	
	public String main() {
		
		return "sayinghello";
	}

}

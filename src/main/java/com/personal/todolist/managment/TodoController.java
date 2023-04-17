package com.personal.todolist.managment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
//@SessionAttributes("description")
public class TodoController {
private TodoService  todoService;
private DataCollection  dataCollection;

	
public TodoController(TodoService todoService) {
	super();
	this.todoService = todoService;
}


@RequestMapping("list-todos")
public String listAllTodos(ModelMap model){
	String name = getLogged(model);
	List<DataCollection> dataCollection=todoService.findByUserName(name);
	model.addAttribute("todos",dataCollection);
	
	return "listTodos";
}





@RequestMapping(value="add-todo",method=RequestMethod.GET)
public String add(ModelMap model){
	String name = getLogged(model);
	DataCollection dataCollection=new DataCollection(0,name,"",LocalDate.now().plusYears(1)  , false);
	model.put("dataCollection", dataCollection);
	
	return "addtodo";
}
@RequestMapping(value="add-todo",method=RequestMethod.POST)
public String add(ModelMap model, @Valid DataCollection dataCollection,BindingResult result){
	if(result.hasErrors())return "addtodo";
	
	model.addAttribute("todos",dataCollection);
	todoService.createtodo(getLogged(model),dataCollection.getDescription(),dataCollection.getTarget(), false);
	return "redirect:list-todos";
}
@RequestMapping(value="delete-todo")
public String delete(@RequestParam int id){
	
	todoService.deletebyid(id);
	
	return "redirect:list-todos";

}
@RequestMapping(value="update")
public String update(@RequestParam int id,ModelMap model){
	
	DataCollection dataCollection=todoService.update(id);
	model.addAttribute("dataCollection",dataCollection);
	
	return "addtodo";

}
@RequestMapping(value="update",method=RequestMethod.GET)
public String updateget(@RequestParam int id,ModelMap model){
	DataCollection dataCollection=todoService.update(id);
	model.addAttribute("dataCollection",dataCollection);
	
	return "addtodo";
}
@RequestMapping(value="update",method=RequestMethod.POST)
public String updatepost(ModelMap model, @Valid DataCollection dataCollection,BindingResult result){
	if(result.hasErrors())return "addtodo";
	
	model.addAttribute("todos",dataCollection);
	dataCollection.setName(getLogged(model));
	todoService.updatetodo(dataCollection);
	return "redirect:list-todos";
}


private String getLogged(ModelMap model) {
	Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
	
	return authentication.getName();
	
	

}







}

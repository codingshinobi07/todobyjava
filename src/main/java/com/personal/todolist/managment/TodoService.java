package com.personal.todolist.managment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
private  static List<DataCollection> dataCollection=new ArrayList<>();

public static int numberof=0;

	static {
		
		dataCollection.add(new DataCollection(++numberof,"author","AWS",(LocalDate.now()).plusYears(1),false));
		dataCollection.add(new DataCollection(++numberof,"author","AWS1",(LocalDate.now()).plusYears(2),true));
		dataCollection.add(new DataCollection(++numberof,"author","AWS2",(LocalDate.now()).plusYears(3),false));
		dataCollection.add(new DataCollection(++numberof,"author","AWS3",(LocalDate.now()).plusYears(4),false));
	}
	
	
	 
	public   List<DataCollection> findByUserName(String name){
		
		Predicate<? super DataCollection>predicate=dataCollection->dataCollection.getName().equalsIgnoreCase(name);
		return dataCollection.stream().filter(predicate).toList();
	}
	public void createtodo(String username,String description,LocalDate date,boolean status) {
		DataCollection data=new 	DataCollection(++numberof,username,description,date,status);
		
		
		dataCollection.add(data);
		
	}
	public void deletebyid(int id) {
		
		Predicate<? super DataCollection>predicate=dataCollection->dataCollection.getId()==id;
		
		dataCollection.removeIf(predicate);
	}
	public DataCollection update(int id) {
		
		Predicate<? super DataCollection>predicate=dataCollection->dataCollection.getId()==id;
		
		DataCollection dataCollection2 = dataCollection.stream().filter(predicate).findFirst().get();
		return dataCollection2;
	}
	public void updatetodo(@Valid DataCollection dataCollection2) {
		// TODO Auto-generated method stub
		deletebyid(dataCollection2.getId());
		
		dataCollection.add(dataCollection2);
	}

	
	
	
}

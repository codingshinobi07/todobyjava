package com.personal.todolist.managment;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;




public class DataCollection {



 public DataCollection(int id, String name,String description, LocalDate target, Boolean done) {
		super();
		this.id = id;
		this.name=name;
		this.description = description;
		this.target = target;
		this.done = done;
	}
 private int id;
 private String name;
 @Size(min=10,message="enter 10 characters")
 private String description;
 private LocalDate target;
 private  Boolean done;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDate getTarget() {
	return target;
}
public void setTarget(LocalDate target) {
	this.target = target;
}
public Boolean getDone() {
	return done;
}
public void setDone(Boolean done) {
	this.done = done;
}
@Override
public String toString() {
	return "DataCollection [id=" + id + ", name=" + name + ", description=" + description + ", target=" + target
			+ ", done=" + done + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}

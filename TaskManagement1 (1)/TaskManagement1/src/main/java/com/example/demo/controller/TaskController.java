package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@CrossOrigin(origins="*")
public class TaskController {
	
	@Autowired
	TaskService taskservice;
	
	@GetMapping("/admin/{id}")
	public Task getTaskById(@PathVariable long id) {
		return taskservice.getTaskById(id);
	}
	
	
	@GetMapping("/admin")
	public List<Task> getAllTasks(){
		return taskservice.getAllTask();
	}
	
	@GetMapping("/admin/comment/{id}")
	public List<Comment> getTaskComment(@PathVariable long id){
		return taskservice.getCommentById(id);
	}
	
	
	@PostMapping("/admin")
	public Task addTask(@RequestBody Task l2) {
		taskservice.addTask(l2);
		return l2;
	}
	
	@PutMapping("/admin/{id}")
	public Task updateTask(@PathVariable long id,@RequestBody Task t1) {
		taskservice.updatetask(id,t1);
		return t1;
	}
	
	@DeleteMapping("admin/{id}")
	public void deleteTask(@PathVariable long id) {
		taskservice.deleteTask(id);
	}
	
	@GetMapping("admin/userTask/{id}")
	public List<Task> getTaskByUserId(@PathVariable long id){
		return taskservice.getTaskByUserId(id);
	}
	
	@PutMapping("/admin/status/{id}")
	public Task updateStatus(@PathVariable long id,@RequestBody Task t1) {
		taskservice.updatetask_status(id, t1);
		return t1;
	}

	@GetMapping("/admin/viewComments")
	public List<Task> getTaskComments(){
		return taskservice.getTaskComments();
	}
}

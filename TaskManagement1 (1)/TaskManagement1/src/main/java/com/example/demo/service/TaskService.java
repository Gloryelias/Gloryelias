package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.feign.CommentServiceClient;
import com.example.demo.model.Comment;
import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	TaskRepo taskrepo;
	
	@Autowired
	private  CommentServiceClient commentServiceClient;

//    public TaskService(CommentServiceClient commentServiceClient) {
//        this.commentServiceClient = commentServiceClient;
//    }
//	
	@Transactional
	public List<Task> getAllTask(){
		return taskrepo.findAll();
	}
	
	@Transactional
	public Task getTaskById(long id) {
		Task result = taskrepo.findById(id).orElseThrow(()->new NoSuchElementException("jhg"));
		return result;
	}
	
	@Transactional
	public Task addTask(Task l2) {
		taskrepo.save(l2);
		return l2;
	}
	
	@Transactional
	public void updatetask_status(long id, Task t1) {
		
		Task t=taskrepo.findById(id).orElseThrow(()->new NoSuchElementException());
		t.setStatus(t1.getStatus());
		taskrepo.save(t);
	}
	
	@Transactional
	public void deleteTask(long id) {
		
		Task t=taskrepo.findById(id).orElseThrow(()->new NoSuchElementException("no element"));
		// TODO Auto-generated method stub
		taskrepo.delete(t);
		
	}

	public List<Task> getTaskByUserId(long id) {
		// TODO Auto-generated method stub
		
		return taskrepo.findByuserid(id);
	}

	public void updatetask(long id, Task t1) {
		Task t=taskrepo.findById(id).orElseThrow(()->new NoSuchElementException());
		System.out.print("********************************************************************hi************************************");
		System.out.println(t1.getTask_name());
		t.setTask_name(t1.getTask_name());
		t.setEndDate(t1.getEndDate());
		t.setUserid(t1.getUserid());
		taskrepo.save(t);
	}

	public List<Comment> getCommentById(long id){
		return commentServiceClient.getCommentByTaskId(id); 
	}

	public List<Task> getTaskComments() {
		List<Task> l1=taskrepo.findAll().stream().filter(task->task.getUserComment()!=null).collect(Collectors.toList());
		return l1;
	}

	public Task updateTaskComment(long id, Task t) {
		// TODO Auto-generated method stub
		Task t1=taskrepo.findById(id).orElseThrow(()->new NoSuchElementException());
		t1.setAdminComment(t.getAdminComment());
		return t1;
	}
}

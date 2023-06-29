package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Comment;

@FeignClient(name="COMMENT-SERVICE")
public interface CommentServiceClient {

	@GetMapping("/comments/all/{id}")
	List<Comment> getCommentByTaskId(@PathVariable("id") long id);
}

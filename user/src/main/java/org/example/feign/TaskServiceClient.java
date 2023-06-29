package org.example.feign;

import java.util.List;

import org.example.domain.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="TASK-SERVICE")
public interface TaskServiceClient {

	@GetMapping("admin/userTask/{id}")
	 List<Task> getTaskByUserId(@PathVariable("id") long id);
		
	
}

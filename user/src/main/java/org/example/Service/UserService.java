package org.example.Service;

import org.example.Repository.UserRepository;
import org.example.domain.Task;
import org.example.domain.User;
import org.example.feign.TaskServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    private final TaskServiceClient taskServiceClient;

    public UserService(TaskServiceClient taskServiceClient) {
        this.taskServiceClient = taskServiceClient;
    }
    

    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public User findUserById(long id) {
        Optional<User> result = userRepository.findById(id);
        User user = result.get();
        return user;
    }

    public void addUser(User user) {

        userRepository.save(user);
    }
    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }
    public void updateUser(User user) {

        Optional<User> result = userRepository.findById(user.getUserId());
        if(result.isPresent())
        {
            userRepository.save(user);
        }
    }
    
    public List<Task> getTasksByUserId(long userId) {
        return taskServiceClient.getTaskByUserId(userId);
    }

}



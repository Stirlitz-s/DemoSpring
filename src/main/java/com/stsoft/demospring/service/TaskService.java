package com.stsoft.demospring.service;

import com.stsoft.demospring.entity.Task;
import com.stsoft.demospring.entity.User;
import com.stsoft.demospring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll(Sort.by(Sort.Order.asc("date"),
                                      Sort.Order.desc("priorityId")));
    }
    public List<Task> getAllUserRecords(User user) {
        /*Integer[] foo = new Integer[1];
        foo[0] = (int) (long) user.getId();
        Iterable<Integer> iterable = Arrays.asList(foo);
        */
        return taskRepository.findByUserId(user.getId());
        
        /*findAll(Sort.by(Sort.Order.asc("date"),
                                      Sort.Order.desc("priorityId")));*/
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task edit(int id) {
    	Task task = taskRepository.findById(id).get();
        return taskRepository.save(task);
    }

    
    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}
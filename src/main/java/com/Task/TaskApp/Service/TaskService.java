package com.Task.TaskApp.Service;

import com.Task.TaskApp.Entity.Task;
import com.Task.TaskApp.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;

    public String addStocks(List<Task> newTask) {
        taskRepo.saveAll(newTask);
        return "added";
    }

    public String addStock(Task newTask) {
        taskRepo.save(newTask);
        return "Task added";
    }

    public List<Task> getAllStocks() {
        return (List<Task>) taskRepo.findAll();
    }

    public String removeTaskById(Integer id) {
        taskRepo.deleteById(id);
        return "Deleted By Id";
    }

    public String updateTaskByID(Integer id, Boolean status) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null) {
            task.setTaskStatus(status);
            taskRepo.save(task);
            return "status updated!!!";
        } else {
            return "Task id not found";
        }
    }
}

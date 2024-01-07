package com.Task.TaskApp.Controller;

import com.Task.TaskApp.Entity.Task;
import com.Task.TaskApp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;


    @PostMapping("tasks")
    public String addStocks(@RequestBody List<Task> newTask)
    {

        return taskService.addStocks(newTask);
    }
    @PostMapping("task")
    public String addStock(@RequestBody Task newTask)
    {

        return taskService.addStock(newTask);
    }

    @GetMapping("tasks")
    public List<Task> getAllStocks()
    {

        return taskService.getAllStocks();
    }


    @DeleteMapping("task/id/{id}")
    public String removeTaskById(@PathVariable Integer id)
    {

        return taskService.removeTaskById(id);
    }

    @PutMapping("task/status/update")
    public String updateTaskByID(@RequestParam Integer id,@RequestParam Boolean status)
    {

        String result =  taskService.updateTaskByID(id,status);
        return result;
    }
}

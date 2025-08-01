package com.LavaCandy.Personal.Task.Manager.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LavaCandy.Personal.Task.Manager.model.*;
import com.LavaCandy.Personal.Task.Manager.service.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // @PostMapping
    // public ResponseEntity<Task> createTask(@RequestBody Task task){
    //     Task createdTask = taskService.createTask(task);
    //     if (createdTask != null) {
    //         return ResponseEntity.ok(createdTask);
    //     } else {
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        if (task != null){
            return ResponseEntity.ok(task);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskService.updateTask(id, task);

        if(updatedTask != null){
            return ResponseEntity.ok(updatedTask);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    
    @PutMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTaskCompletion(@PathVariable Long id){
        Task toggledTask = taskService.toggleTaskCompletion(id);

        if(toggledTask != null){
            return ResponseEntity.ok(toggledTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}

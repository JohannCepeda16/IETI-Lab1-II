package edu.escuelaing.ieti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.ieti.data.Task;
import edu.escuelaing.ieti.dto.TaskDto;
import edu.escuelaing.ieti.service.TaskService;

@RestController
@RequestMapping("v1/task")
public class TaskController {

    private final TaskService taskServices;

    public TaskController(@Autowired TaskService taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping()
    public ResponseEntity<List<Task>> all() {
        try {
            return ResponseEntity.ok().body(taskServices.all());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(taskServices.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto) {
        try {
            Task task = new Task("", taskDto.getName(), taskDto.getDescription(), taskDto.getStatus(),
                    taskDto.getAssignedTo(), taskDto.getDueDate(), taskDto.getCreated());
            return ResponseEntity.ok().body(taskServices.create(task));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @RequestBody TaskDto taskDto) {
        try {
            Task task = taskServices.findById(id);
            if (task != null) {
                task.setAssignedTo(taskDto.getAssignedTo());
                task.setCreated(taskDto.getCreated());
                task.setDescription(taskDto.getDescription());
                task.setDueDate(taskDto.getDescription());
                task.setName(taskDto.getName());
                task.setStatus(taskDto.getStatus());
                return ResponseEntity.ok().body(taskServices.update(task, id));
            }
            return ResponseEntity.status(404).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        try {
            boolean deleted = false;
            taskServices.deleteById(id);
            deleted = taskServices.findById(id) != null ? false : true; 
            return ResponseEntity.ok().body(deleted);
            
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

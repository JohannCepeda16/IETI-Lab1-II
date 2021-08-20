package edu.escuelaing.ieti.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.escuelaing.ieti.data.Task;
import edu.escuelaing.ieti.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private HashMap<String, Task> tasks = new HashMap<>();

    @Override
    public Task create(Task task) {
        task.setId(String.valueOf(tasks.size()));
        return tasks.put(task.getId(), task);
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> all() {
        List<Task> tasks = (List<Task>) this.tasks.values();
        return tasks;
    }

    @Override
    public void deleteById(String id) {
        tasks.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        return tasks.put(id, task);
    }

}

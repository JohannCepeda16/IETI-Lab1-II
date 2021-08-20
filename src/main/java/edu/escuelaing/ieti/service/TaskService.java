package edu.escuelaing.ieti.service;

import java.util.List;

import edu.escuelaing.ieti.data.Task;

public interface TaskService {
    Task create(Task task);

    Task findById(String id);

    List<Task> all();

    void deleteById(String id);

    Task update(Task task, String id);
}

package org.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.rest.entity.Task;
import org.rest.repository.TaskRepository;
import org.rest.service.TaskService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.getReferenceById(taskId);
    }

}

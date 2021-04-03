package service.task;

import model.task.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class TaskService {

    public Task findTaskById(Long id) {
        return null;
    }

    public Task findAllTask() { return null; }

    public Task persistTask(@Valid Task task) {
        return null;
    }

    public Task updateTask(@Valid Task task) {
        return null;
    }

    public Task deleteTask(Long id) {
        return null;
    }
}

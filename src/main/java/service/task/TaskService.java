package service.task;

import dto.task.TaskDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import model.customer.PetOwner;
import model.task.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class TaskService {

    public TaskDTO findTaskById(long id) {
        return new TaskDTO(Task.findById(id));
    }

    public List<TaskDTO> findAll() {
        List<Task> list = Task.listAll();
        List<TaskDTO> listDto = new ArrayList<>();
        list.forEach(i -> listDto.add(new TaskDTO(i)));
        return listDto;
    }

    public List<TaskDTO> findAllTask(String filter) {
        List<Task> list = Task.list("animaltype", filter);
        List<TaskDTO> listDto = new ArrayList<>();
        list.forEach(i -> listDto.add(new TaskDTO(i)));

        return listDto;

    }

    @Transactional
    public void persistTask(@Valid TaskDTO dto) {
        Task task = new Task(dto);

        PanacheQuery<PanacheEntityBase> result = PetOwner.find("id", dto.getCustomer().getId());
        PetOwner customer = result.firstResult();

        task.setCustomer(customer);
        task.persist();
    }

    public Task updateTask(@Valid Task task) {
        return null;
    }

}

package dto.customer;

import dto.notification.NotificationDTO;
import dto.task.TaskDTO;
import model.customer.PetOwner;
import model.profile.Profile;

public class PetOwnerDTO extends CustomerDTO{

    private long id;
    private TaskDTO task;
    private NotificationDTO notification;

    public PetOwnerDTO() {
    }

    public PetOwnerDTO(long id) {
        this.id = id;
    }

    public PetOwnerDTO(long id, String login) {
        this.id = id;
        this.login = login;
    }

    public PetOwnerDTO(PetOwner petOwner) {
        this.id = petOwner.id;
        this.task = new TaskDTO(new PetOwnerDTO(id),
                petOwner.getTask().getAnimalType(),
                petOwner.getTask().getStart_date(),
                petOwner.getTask().getEnd_date(),
                petOwner.getTask().isScheduled());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public NotificationDTO getNotification() {
        return notification;
    }

    public void setNotification(NotificationDTO notification) {
        this.notification = notification;
    }
}

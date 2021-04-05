package dto.task;

import dto.customer.PetOwnerDTO;
import utils.AnimalType;
import model.task.Task;

import java.time.LocalDate;

public class TaskDTO {

//    private long id;
    private AnimalType animalType;
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean scheduled;

    private PetOwnerDTO customer;
//    private NotificationDTO notification;


    public TaskDTO() {
    }

    public TaskDTO(PetOwnerDTO customer, AnimalType animalType, LocalDate start_date, LocalDate end_date, boolean scheduled) {
        this.animalType = animalType;
        this.start_date = start_date;
        this.end_date = end_date;
        this.scheduled = scheduled;
        this.customer = customer;
    }

    public TaskDTO(Task task){
        this.animalType = task.getAnimalType();
        this.start_date = task.getStart_date();
        this.end_date = task.getEnd_date();
        this.scheduled = task.isScheduled();
        this.customer = new PetOwnerDTO(task.getCustomer());
        this.customer.setId(task.getCustomer().id);
    }


    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    public PetOwnerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(PetOwnerDTO customer) {
        this.customer = customer;
    }
}

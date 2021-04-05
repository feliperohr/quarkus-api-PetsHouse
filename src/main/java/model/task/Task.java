package model.task;

import dto.task.TaskDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import utils.AnimalType;
import model.customer.PetOwner;
import model.notification.Notification;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Task extends PanacheEntity {

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "pet_owner_id")
    @NotNull
    private PetOwner customer;

    @OneToMany(mappedBy = "task")
    private List<Notification> list = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private LocalDate start_date;

    private LocalDate end_date;

    @Column(columnDefinition = "boolean default false")
    private boolean scheduled;

    public Task() {
    }

    public Task(TaskDTO dto){
        this.animalType = dto.getAnimalType();
        this.start_date = dto.getStart_date();
        this.end_date = dto.getEnd_date();
        this.scheduled = dto.isScheduled();
        this.customer = new PetOwner(dto.getCustomer());
    }

    public Task(@NotNull PetOwner customer, AnimalType animalType, LocalDate start_date, LocalDate end_date, boolean scheduled) {
        this.customer = customer;
        this.animalType = animalType;
        this.start_date = start_date;
        this.end_date = end_date;
        this.scheduled = scheduled;
    }

    public PetOwner getCustomer() {
        return customer;
    }

    public void setCustomer(PetOwner customer) {
        this.customer = customer;
    }

    public List<Notification> getList() {
        return list;
    }

    public void setList(List<Notification> list) {
        this.list = list;
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
}

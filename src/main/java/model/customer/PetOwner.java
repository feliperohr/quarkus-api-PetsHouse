package model.customer;

import model.notification.Notification;
import model.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PetOwner extends Customer{

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Task task;

    @OneToMany(mappedBy = "pet_owner")
    private List<Notification> list = new ArrayList<>();

}

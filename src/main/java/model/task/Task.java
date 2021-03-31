package model.task;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import model.profile.AnimalType;
import model.customer.PetOwner;
import model.notification.Notification;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
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

    private Date start_date;

    private Date end_date;

    @Column(columnDefinition = "boolean default false")
    private boolean scheduled;


}

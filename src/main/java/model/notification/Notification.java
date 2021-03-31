package model.notification;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import model.customer.PetOwner;
import model.customer.PetSitter;
import model.task.Task;

import javax.persistence.*;

@Entity
public class Notification extends PanacheEntityBase {

    @EmbeddedId
    private NotificationID id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'WAITING'")
    private Status status;


    @OneToOne
    @JoinColumn(name = "pet_sitter_id", insertable = false, updatable = false)
    private PetSitter pet_sitter;

    @OneToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner pet_owner;

    @ManyToOne
    @JoinColumn(name = "task_id", insertable = false, updatable = false)
    private Task task;

}

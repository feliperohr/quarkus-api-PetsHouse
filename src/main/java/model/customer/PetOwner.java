package model.customer;

import dto.customer.CustomerDTO;
import dto.customer.PetOwnerDTO;
import model.notification.Notification;
import model.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PetOwner extends Customer{

    @OneToOne(mappedBy = "customer")
    private Task task;

    @OneToMany(mappedBy = "pet_owner")
    private List<Notification> list = new ArrayList<>();

    public PetOwner() {
    }

//    public PetOwner(CustomerDTO dto){
//
//    }

    public PetOwner(PetOwnerDTO dto) {
        this.login = dto.getLogin();
        this.password = dto.getPassword();
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Notification> getList() {
        return list;
    }

    public void setList(List<Notification> list) {
        this.list = list;
    }


}

package model.customer;

import dto.customer.CustomerDTO;
import model.notification.Notification;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PetSitter extends Customer{

    @OneToOne(mappedBy = "pet_sitter")
    private Notification notification;

    public PetSitter() {
    }

    public PetSitter(CustomerDTO dto) {
        this.login = dto.getLogin();
        this.password = dto.getPassword();
    }
}

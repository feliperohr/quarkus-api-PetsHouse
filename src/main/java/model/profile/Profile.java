package model.profile;

import dto.profile.ProfileDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import model.customer.Customer;
import utils.AnimalType;

import javax.persistence.*;


@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames="cpf")})
public class Profile extends PanacheEntity {

    private String name;
    private String cpf;
    private String phone;

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    public Customer customer;

    public Profile() {
    }

    public Profile(ProfileDTO dto) {
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.phone = dto.getPhone();
        this.animalType = dto.getAnimalType();
        this.customer = new Customer(dto.getCustomer());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

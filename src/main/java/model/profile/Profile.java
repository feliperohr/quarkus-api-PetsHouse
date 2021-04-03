package model.profile;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import model.customer.Customer;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames="cpf")})
public class Profile extends PanacheEntity {

    private String name;

    private String cpf;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    public Customer customer;

    @Enumerated(EnumType.STRING)
    private model.profile.AnimalType animalType;

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
}

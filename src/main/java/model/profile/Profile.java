package model.profile;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import model.customer.Customer;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames="cpf")})
public class Profile extends PanacheEntity {

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    private String name;

    private String cpf;

    private String phone;

    @Enumerated(EnumType.STRING)
    private model.profile.AnimalType AnimalType;

}

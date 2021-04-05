package dto.profile;

import dto.customer.CustomerDTO;
import utils.AnimalType;
import model.profile.Profile;

public class ProfileDTO {

    private String name;
    private String cpf;
    private String phone;
    private AnimalType animalType;
    private CustomerDTO customer;

    public ProfileDTO() {
    }

    public ProfileDTO(CustomerDTO customer, String name, String cpf, String phone, AnimalType animalType) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.animalType = animalType;
        this.customer = customer;
    }

    public ProfileDTO(Profile profile) {
        this.name = profile.getName();
        this.cpf = profile.getCpf();
        this.phone = profile.getPhone();
        this.animalType = profile.getAnimalType();
        this.customer = new CustomerDTO(profile.getCustomer());
        this.customer.setId(profile.getCustomer().id);
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

}

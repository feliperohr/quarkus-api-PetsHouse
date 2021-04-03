package dto.profile;

import model.profile.AnimalType;
import model.profile.Profile;

public class ProfileDTO {

    private long id;

    private String name;

    private String cpf;

    private String phone;

    private model.profile.AnimalType animalType;

    public ProfileDTO() {
    }

    public ProfileDTO(String name, String cpf, String phone, AnimalType animalType) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.animalType = animalType;
    }

    public ProfileDTO(long id, String name, String cpf, String phone, AnimalType animalType) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.animalType = animalType;
    }

    public ProfileDTO(Profile profile) {
        this.id = profile.id;
        this.name = profile.getName();
        this.cpf = profile.getCpf();
        this.phone = profile.getPhone();
        this.animalType = profile.getAnimalType();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}

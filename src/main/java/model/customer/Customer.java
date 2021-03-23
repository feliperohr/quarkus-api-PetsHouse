package model.customer;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import model.profile.Profile;

import javax.persistence.Entity;

@Entity
public abstract class Customer extends PanacheEntity {

    private String login;
    private String password;

//    public Profile profile;

    public Customer() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

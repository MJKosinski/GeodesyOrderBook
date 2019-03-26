package com.geohor.entity;

import com.geohor.myenum.UserType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String login;


    @NotBlank
    private String password;


    @NotBlank
    @Column(unique = true)
    private String email;


    @Column
    private UserType type;

    @Transient
    private List<String> mailingList;

    @ManyToMany(mappedBy = "subcontractors", fetch = FetchType.EAGER)
    private List<Work> orderList = new ArrayList<>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<String> getMailingList() {
        return mailingList;
    }

    public void setMailingList(List<String> mailingList) {
        this.mailingList = mailingList;
    }

    public List<Work> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Work> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}

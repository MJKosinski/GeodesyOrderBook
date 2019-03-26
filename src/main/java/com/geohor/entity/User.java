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


    @NotBlank
    private UserType type;

    @Transient
    private List<String> mailingList;

    @ManyToMany(mappedBy = "subcontractors")
    private List<Work> orderList = new ArrayList<>();


}

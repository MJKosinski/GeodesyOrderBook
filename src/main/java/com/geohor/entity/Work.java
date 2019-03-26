package com.geohor.entity;

import com.geohor.myenum.CatalogType;
import com.geohor.myenum.StatusType;
import com.geohor.myenum.WorkType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="geodetic_work")
public class Work {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // People

    @ManyToOne
    @NotBlank
    private User declarant;

    @ManyToOne
    private User geodesyPerformer;

    @ManyToMany
    private List<User> subcontractors;


    // Dates
    private LocalDateTime applicationDate;

    private LocalDate workDate;

    private LocalDate submissionDate;


    //Work identification

    @NotBlank
    private CatalogType catalog;


    @NotBlank
    private String trade;

    @NotBlank
    private String object;

    @NotBlank
    private WorkType workType;

    @NotBlank
    private String mileageStart;

    @Column
    private String mileageEnd;

    @Column
    private String describtion;

    @Column
    private String declarantComment;

    @Column
    private String geodesyComment;

    @Column
    private String constructFieldRaport;

    @Column
    @NotBlank
    private StatusType status;













}

/*
Katalog
branża
Obiekt
Kilometraż od
Kilometraż do
TYCZ/INW/OBL

Temat
Uwagi dla operatu
Uwagi dla terenowców
Załącznik od GW
Załącznik dla GW
raport z terenu
status zgłoszenia

 */
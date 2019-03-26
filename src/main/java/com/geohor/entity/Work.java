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


    public Work() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getDeclarant() {
        return declarant;
    }

    public void setDeclarant(User declarant) {
        this.declarant = declarant;
    }

    public User getGeodesyPerformer() {
        return geodesyPerformer;
    }

    public void setGeodesyPerformer(User geodesyPerformer) {
        this.geodesyPerformer = geodesyPerformer;
    }

    public List<User> getSubcontractors() {
        return subcontractors;
    }

    public void setSubcontractors(List<User> subcontractors) {
        this.subcontractors = subcontractors;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public CatalogType getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogType catalog) {
        this.catalog = catalog;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public String getMileageStart() {
        return mileageStart;
    }

    public void setMileageStart(String mileageStart) {
        this.mileageStart = mileageStart;
    }

    public String getMileageEnd() {
        return mileageEnd;
    }

    public void setMileageEnd(String mileageEnd) {
        this.mileageEnd = mileageEnd;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getDeclarantComment() {
        return declarantComment;
    }

    public void setDeclarantComment(String declarantComment) {
        this.declarantComment = declarantComment;
    }

    public String getGeodesyComment() {
        return geodesyComment;
    }

    public void setGeodesyComment(String geodesyComment) {
        this.geodesyComment = geodesyComment;
    }

    public String getConstructFieldRaport() {
        return constructFieldRaport;
    }

    public void setConstructFieldRaport(String constructFieldRaport) {
        this.constructFieldRaport = constructFieldRaport;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", declarant=" + declarant +
                ", geodesyPerformer=" + geodesyPerformer +
                ", applicationDate=" + applicationDate +
                ", workDate=" + workDate +
                ", submissionDate=" + submissionDate +
                ", catalog=" + catalog +
                ", trade='" + trade + '\'' +
                ", object='" + object + '\'' +
                ", workType=" + workType +
                ", mileageStart='" + mileageStart + '\'' +
                ", mileageEnd='" + mileageEnd + '\'' +
                ", describtion='" + describtion + '\'' +
                ", declarantComment='" + declarantComment + '\'' +
                ", geodesyComment='" + geodesyComment + '\'' +
                ", constructFieldRaport='" + constructFieldRaport + '\'' +
                ", status=" + status +
                '}';
    }
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
package com.architeo.ehiringapp.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfCompany;
    private String companyPhone;
    private String companyEmail;
    private String Logo;
    @ManyToMany(mappedBy = "clients")
    private Set<Candidate> candidates;
     public Client(String nameOfCompany,String companyPhone,String companyEmail){
        this.nameOfCompany=nameOfCompany;
        this.companyPhone=companyPhone;
        this.companyEmail=companyEmail;
    }
    public Client(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public Long getId() {
        return id;
    }
}

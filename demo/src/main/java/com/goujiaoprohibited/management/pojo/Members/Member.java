package com.goujiaoprohibited.management.pojo.Members;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Table(name="tb_member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String memberName;
    private String password;
    private String member_class;
    private String specialty;
    private double EP;
    private double GP;
    private double EPGP;

    @PrePersist
    @PreUpdate
    public void setEPGP() {
        if (this.GP == 0) {
            this.EPGP = 0;
        } else {
            this.EPGP = EP / GP;
        }
    }

    public double getEpgp() {
        return EPGP;
    }

    public double getEP() {
        return EP;
    }

    public double getGP() {
        return GP;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getMember_class() {
        return member_class;
    }

    public void setEP(double eP) {
        EP = eP;
    }

    public void setGP(double gP) {
        GP = gP;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setMember_class(String member_class) {
        this.member_class = member_class;
    }
    
    @Override
    public String toString() {
        return "super.toString()";
    }
}

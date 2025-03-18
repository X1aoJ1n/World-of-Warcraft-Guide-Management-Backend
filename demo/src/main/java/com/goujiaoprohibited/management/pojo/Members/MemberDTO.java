package com.goujiaoprohibited.management.pojo.Members;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;

public class MemberDTO {
    private int memberId;
    @NotBlank(message = "用户名不能为空哦")
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


    public double getEP() {
        return EP;
    }

    public double getGP() {
        return GP;
    }

    public double getEPGP() {
        return EPGP;
    }

    public void setEP(double eP) {
        EP = eP;
    }
    
    public void setGP(double gP) {
        GP = gP;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMemberId() {
        return memberId;
    }
    
    public String getMember_class() {
        return member_class;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMember_class(String member_class) {
        this.member_class = member_class;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

package com.example.admin.restaurantmanagement.EmployManagement;

public class EmployManagementInfo {
    Integer imgEmploy;
    String employName, birthDate;

    public EmployManagementInfo(Integer imgEmploy, String employName, String birthDate) {
        this.imgEmploy = imgEmploy;
        this.employName = employName;
        this.birthDate = birthDate;
    }

    public Integer getImgEmploy() {
        return imgEmploy;
    }

    public void setImgEmploy(Integer imgEmploy) {
        this.imgEmploy = imgEmploy;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

package com.example.admin.restaurantmanagement.EmployManagement;

public class EmployManagementInfo {
    Integer imgEmploy;
    String employName, phone, email, pass;
    String url;

    public EmployManagementInfo(){}

    public EmployManagementInfo(String employName, String phone, String email, String pass, String url) {
        this.employName = employName;
        this.phone = phone;
        this.email = email;
        this.pass = pass;
        this.url = url;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

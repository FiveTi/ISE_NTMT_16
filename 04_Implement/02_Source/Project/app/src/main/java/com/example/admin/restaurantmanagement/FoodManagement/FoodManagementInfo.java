package com.example.admin.restaurantmanagement.FoodManagement;

public class FoodManagementInfo {
    Integer imgFood;
    String foodName, price, type;

    public FoodManagementInfo(Integer imgFood, String foodName, String price, String type) {
        this.imgFood = imgFood;
        this.foodName = foodName;
        this.price = price;
        this.type = type;
    }

    public Integer getImgFood() {
        return imgFood;
    }

    public void setImgFood(Integer imgFood) {
        this.imgFood = imgFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

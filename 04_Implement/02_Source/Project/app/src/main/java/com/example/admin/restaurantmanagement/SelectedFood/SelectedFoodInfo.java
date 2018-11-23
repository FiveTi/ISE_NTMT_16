package com.example.admin.restaurantmanagement.SelectedFood;

public class SelectedFoodInfo {
    String foodName, price, count, sum;
    Integer imgFood;

    public SelectedFoodInfo(String foodName, String price, String count, Integer imgFood) {
        this.foodName = foodName;
        this.price = price;
        this.count = count;
        this.imgFood = imgFood;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Integer getImgFood() {
        return imgFood;
    }

    public void setImgFood(Integer imgFood) {
        this.imgFood = imgFood;
    }
}

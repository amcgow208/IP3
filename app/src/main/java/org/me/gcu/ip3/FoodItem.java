package org.me.gcu.ip3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class FoodItem implements Serializable {

    @SerializedName("foodId")
    private String foodId;

    @SerializedName("label")
    private String label;

    @SerializedName("nutrients")
    private Map<String, Double> nutrients;

    @SerializedName("brand")
    private String brand;

    @SerializedName("category")
    private String category;

    @SerializedName("foodContentsLabel")
    private String foodContentsLabel;

    @SerializedName("image")
    private String image;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Double> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Map<String, Double> nutrients) {
        this.nutrients = nutrients;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "foodId='" + foodId + '\'' +
                ", label='" + label + '\'' +
                ", nutrients=" + nutrients +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", foodContentsLabel='" + foodContentsLabel + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

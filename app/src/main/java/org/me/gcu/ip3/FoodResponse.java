package org.me.gcu.ip3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FoodResponse implements Serializable {

    @SerializedName("hints")
    private List<Hint> hints;

    public List<Hint> getHints() {
        return hints;
    }

    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

    public static class Hint {
        @SerializedName("food")
        private FoodItem foodItem;

        public FoodItem getFoodItem() {
            return foodItem;
        }

        public void setFoodItem(FoodItem foodItem) {
            this.foodItem = foodItem;
        }
    }
}


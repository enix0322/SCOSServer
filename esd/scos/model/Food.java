package esd.scos.model;

import java.io.Serializable;

public class Food implements Serializable {
    private String food_name;
    private int food_price;
    private int food_store_num;

    public Food(String food_name, int food_price) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_store_num = 1;
    }
    public String get_food_name() {
        if(food_name.equals(null)) {
            food_name = "";
        }
        return food_name;
    }

    public int get_food_price() {
        return food_price;
    }

    public int get_food_store_num() {
        return food_store_num;
    }

    public void set_food_name(String food_name) {

        this.food_name = food_name;
    }

    public void set_food_price(int food_price) {

        this.food_price = food_price;
    }

    public void set_food_store_num(int food_store_num) {

        this.food_store_num = food_store_num;
    }
}

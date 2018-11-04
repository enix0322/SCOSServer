package esd.scos;

import esd.scos.model.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Food_Data {
    String Food_cold = "D:/USTC/Course/Android_software_design/homework/SCOSServer/Food_data_cold.dat";
    String Food_drink = "D:/USTC/Course/Android_software_design/homework/SCOSServer/Food_data_drink.dat";
    String Food_hot = "D:/USTC/Course/Android_software_design/homework/SCOSServer/Food_data_hot.dat";
    String Food_sea = "D:/USTC/Course/Android_software_design/homework/SCOSServer/Food_data_sea.dat";

    static int len_cold = 0;
    static int len_hot = 0;
    static int len_sea = 0;
    static int len_drink = 0;

    public void newfood(int new_food) {
        if(new_food ==1) {
            len_cold = 0;
            len_hot = 0;
            len_sea = 0;
            len_drink = 0;
        }
    }
    public List<Food> get_food_data(String FoodType) {
        switch (FoodType){
            case "cold_food":
                List<Food> Food_data_cold = new ArrayList<>();
                Food_data_cold.addAll(readFileByLines(Food_cold));
                if(len_cold < Food_data_cold.size()) {
                    len_cold = Food_data_cold.size();
                    return Food_data_cold;
                }
                break;
            case "hot_food":
                List<Food> Food_data_hot = new ArrayList<>();
                Food_data_hot.addAll(readFileByLines(Food_hot));
                if(len_hot < Food_data_hot.size()) {
                    len_hot = Food_data_hot.size();
                    return Food_data_hot;
                }
                break;
            case "sea_food":
                List<Food> Food_data_sea = new ArrayList<>();
                Food_data_sea.addAll(readFileByLines(Food_sea));
                if(len_sea < Food_data_sea.size()) {
                    len_sea = Food_data_sea.size();
                    return Food_data_sea;
                }
                break;
            case "drink_food":
                List<Food> Food_data_drink = new ArrayList<>();
                Food_data_drink.addAll(readFileByLines(Food_drink));
                if(len_drink < Food_data_drink.size()) {
                    len_drink = Food_data_drink.size();
                    return Food_data_drink;
                }
                break;
        }
        return new ArrayList<>();
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public List<Food> readFileByLines(String fileName) {

        List<Food> foodList = new ArrayList<>();
        BufferedReader reader = null;
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
            reader = new BufferedReader(in);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if(!tempString.equals("")) {
                    String[] str = tempString.split(",");
                    foodList.add(new Food(str[0], Integer.valueOf(str[1])));
                }
            }
            reader.close();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return foodList;
    }
}

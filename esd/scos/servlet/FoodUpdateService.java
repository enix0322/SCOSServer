package esd.scos.servlet;


import esd.scos.Food_Data;
import esd.scos.model.Food;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jetbrains.annotations.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FoodUpdateService extends HttpServlet {
    Food_Data food_data = new Food_Data();

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        doGet(req, res);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/json");
        String acceptjson = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while((temp = br.readLine()) != null){
            sb.append(temp);
        }
        br.close();
        acceptjson = sb.toString();
        JSONObject json_obj = JSONObject.fromObject(acceptjson);
        String food_type = json_obj.getString("FoodType");
        int new_food = json_obj.getInt("new_food");
        System.out.println("=======json is==========="+acceptjson);
        if(acceptjson != "" && food_type!= ""){
            List<Food> Food_data_cold = new ArrayList<>();
            food_data.newfood(new_food);
            Food_data_cold.addAll(food_data.get_food_data(food_type));
            String jsonStr = FoodIn2Json(Food_data_cold);
            PrintWriter out = res.getWriter();
            out.write(jsonStr);
            out.close();
            System.out.println("菜单列表长度" + Food_data_cold.size());
        }
        else{
        }
    }
    public void init() throws ServletException {
    }

    @Contract("null -> !null")
    private String FoodIn2Json(List<Food> items){
        if (items == null) return "";
        JSONArray array = new JSONArray();
        JSONObject jsonObject = null;
        Food info = null;
        for (int i = 0; i < items.size(); i++) {
            info = items.get(i);
            jsonObject = new JSONObject();
            jsonObject.put("food_name", info.get_food_name());
            jsonObject.put("food_price", info.get_food_price());
            jsonObject.put("food_store_num", info.get_food_store_num());
            array.add(jsonObject);
        }
        return array.toString();
    }
}

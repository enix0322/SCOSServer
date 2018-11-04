package esd.scos.servlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;



public class LoginValidator extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("发送get请求。。。。。。。。。。。");
        doPost(req, res);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/json");
        String acceptjson = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while((temp = br.readLine()) != null){
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
            System.out.println("=======json is==========="+acceptjson);
            if(acceptjson != ""){
                System.out.println("get the json successfully");
                String jsonStr ="{\"RESULTCODE\":\"1\"}";
                PrintWriter out = res.getWriter();
                out.write(jsonStr);
                out.close();
            }
            else{
                System.out.println("get the json failed");
                String jsonStr ="{\"RESULTCODE\":\"0\"}";
                PrintWriter out = res.getWriter();
                out.write(jsonStr);
                out.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void init() throws ServletException{
        // Put your code here
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }
}

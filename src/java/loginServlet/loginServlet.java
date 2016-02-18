package loginServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String user_ID_from_DB = "";
    String user_password_from_DB = "";
    Connection connection = null;
    Statement querySmt = null;
    ResultSet result = null;

    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException{
        // TODO Auto-generated method stub
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        String user_name = request.getParameter("user_name").trim();
        String password = request.getParameter("password").trim();
        // Database operations using JDBC
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // load the driver
            String url = "jdbc:sqlserver://FAGOTS08:1433;databaseName=DepPlast";
            Connection conn = DriverManager.getConnection(url, user_name, password);
            if (conn == null) {
                System.out.println("connection was failed"); 
                request.getRequestDispatcher("/fail.jsp");//.forward(request, response);
            }else {
                System.out.println("connected successfully");
                request.getRequestDispatcher("/success.jsp").forward(request, response);//.forward(request, response);    
            /*/ Select user from database to check user login id and password
                querySmt = connection.createStatement();
                result = querySmt.executeQuery("select * from Authentication where login_id = '"+ user_id + "'");
                if (!result.equals(null)) {
                    while (result.next()) {
                        user_ID_from_DB = result.getString("login_id").trim();
                        user_password_from_DB = result.getString("password").trim();
                        System.out.println(user_ID_from_DB + " " + user_password_from_DB);
                    }
                    // Database operations completed
                    if (user_id.equals(user_ID_from_DB) && password.equals(user_password_from_DB)) {
                        request.getRequestDispatcher("/success.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/fail.jsp").forward(request, response);
                    }
                } 
                else {
                    request.getRequestDispatcher("/fail.jsp").forward(request, response);
                }*/
            }                    
        }catch(SQLException sqle) {
                System.out.println("Sql Exception :"+sqle.getMessage());
        }catch(ClassNotFoundException e) {
                System.out.println("Class Not Found Exception :" + e.getMessage());
        }/*catch(IOException e) {
            e.printStackTrace();  // or handle in some other way
        }*/
    }
}
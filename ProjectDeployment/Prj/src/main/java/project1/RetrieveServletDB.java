package project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/RetrieveServletDB")
public class RetrieveServletDB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Connection con;

    public RetrieveServletDB() {
        super();
    }

    static void initialProcess() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.cj.jdbc.Driver";  // ✅ Updated for MySQL 8+
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "sales";
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // ✅ Ensure proper HTML content type

        try (PrintWriter out = response.getWriter()) { // ✅ Auto-closing PrintWriter
            initialProcess();
            Statement st1 = con.createStatement();
            String query = "SELECT * FROM salesperson";
            ResultSet rs = st1.executeQuery(query);

            StringBuilder output = new StringBuilder();
            output.append("<html><body>");

            // ✅ Correct way to check if ResultSet is empty
            if (!rs.isBeforeFirst()) {  
                output.append("<b>No Records Found</b><br>");
            } else {
                while (rs.next()) {
                    output.append("<b>").append(rs.getString(2)).append(" ").append(rs.getString(3)).append("</b><br>");
                }
            }

            output.append("<a href='default.html'>Back</a></body></html>");
            out.println(output);

            // ✅ Close resources properly
            rs.close();
            st1.close();
            con.close();

            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            e.printStackTrace(); // ✅ Print SQL errors
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // ✅ Print class loading errors
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

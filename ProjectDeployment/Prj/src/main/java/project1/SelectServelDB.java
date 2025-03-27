package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServelDB
 */
@WebServlet("/SelectServelDB")
public class SelectServelDB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Connection con = null;

    // Static block to initialize the database connection
    static {
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/sales"; 
            String dbUsername = "root"; 
            String dbPassword = "root"; 
            Class.forName(dbDriver); 
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public SelectServelDB() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            String salesId = request.getParameter("s_id");
            if (salesId == null || salesId.trim().isEmpty()) {
                out.println("<html><body><b>Invalid Input</b></body></html>");
                return;
            }

            PreparedStatement st = con.prepareStatement("SELECT * FROM salesperson WHERE s_id = ?"); 
            st.setString(1, salesId);
            ResultSet rs = st.executeQuery();

            out.println("<html><body>");
            
            boolean recordFound = false;
            while (rs.next()) {
                recordFound = true;
                out.println("<b>" + rs.getString(2) + " " + rs.getString(3) + "</b><br>");
            }

            if (!recordFound) {
                out.println("<b>No Record Found</b><br>");
            }

            out.println("<a href='default.html'>Back</a></body></html>");

            // Close resources
            rs.close();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body><b>Error Occurred</b></body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

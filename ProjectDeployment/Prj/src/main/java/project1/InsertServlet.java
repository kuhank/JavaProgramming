package project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Connection con;

    // Initialize database connection once
    static {
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/sales"; 
            String dbUsername = "root"; 
            String dbPassword = "root"; 

            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  // Log error
        }
    }

    public InsertServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            String empId = request.getParameter("Empid");
            String empName = request.getParameter("EmpName");
            String mobileStr = request.getParameter("Mobile");

            if (empId == null || empId.trim().isEmpty() ||
                empName == null || empName.trim().isEmpty() ||
                mobileStr == null || mobileStr.trim().isEmpty()) {
                out.println("<html><body><b>Invalid Input</b></body></html>");
                return;
            }

            int mobile;
            try {
                mobile = Integer.parseInt(mobileStr);
            } catch (NumberFormatException e) {
                out.println("<html><body><b>Invalid Mobile Number</b></body></html>");
                return;
            }

            PreparedStatement st = con.prepareStatement("INSERT INTO personal VALUES (?, ?, ?)"); 
            st.setString(1, empId);
            st.setString(2, empName);
            st.setInt(3, mobile);

            int res = st.executeUpdate();
            st.close(); 

            if (res == 1) {
                out.println("<html><body><b>Successfully Inserted</b></body></html>");
            } else {
                out.println("<html><body><b>Error in Insertion</b></body></html>");
            }

            out.println("<a href='default.html'>Back</a>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body><b>Database Error</b></body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

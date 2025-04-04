

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
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
       static Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    static void initialProcess() throws SQLException,ClassNotFoundException
    {
    	
		String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "empdb"; 
        String dbUsername = "root"; 
        String dbPassword = "root"; 
  
        Class.forName(dbDriver); 
        con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword);
        
  
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
			InsertServlet.initialProcess();
		
        PreparedStatement st = con 
                .prepareStatement("insert into personal values(?,?,?)"); 

         // For the first parameter, 
         // get the data using request object 
         // sets the data to st pointer 
         st.setString(1,request.getParameter("Empid")); 

         // Same for second parameter 
         st.setString(2, request.getParameter("EmpName")); 
         st.setInt(3, Integer.valueOf(request.getParameter("Mobile"))); 

         // Execute the insert command using executeUpdate() 
         // to make changes in database 
         int res=st.executeUpdate(); 

         // Close all the connections 
         st.close(); 
         con.close(); 
System.out.println("ok");
         // Get a writer pointer  
         // to display the successful result 
         PrintWriter out = response.getWriter(); 
         if(res==1)
         out.println("<html><body><b>Successfully Inserted"
                     + "</b>");
         else
        	 out.println("<html><body><b>Error"
                     + "</b>");
        	 
    
		
		out.println("<a href=/prj/default.html>Back</a></body></html>");
		}
		catch(SQLException e)
        {
        }
		catch(ClassNotFoundException e)
        {
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

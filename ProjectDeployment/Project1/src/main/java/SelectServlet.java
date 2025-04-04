

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    static void initialProcess() throws SQLException,ClassNotFoundException
    {
    	
		String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "sales"; 
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
			SelectServlet.initialProcess();
		
        PreparedStatement st = con.prepareStatement("select * from salesperson where s_id=?"); 
  st.setString(1, request.getParameter("s_id"));
  //      Statement st1=con.createStatement();
    //    String query="select * from personal";
         // For the first parameter, 
         // get the data using request object 
         // sets the data to st pointer 
         //st.setString(1,request.getParameter("Empid")); 

         // Same for second parameter 
         ResultSet rs=st.executeQuery(); 
         
         PrintWriter out = response.getWriter(); 

if (rs==null)
	out.println("<html><body><b>No Record</b>");
else
{     while(rs.next())
        	 out.println("<html><body><b>"+rs.getString(2)+rs.getString(3)+ "</b>");
}

         // Close all the connections 
         st.close(); 
         con.close(); 
System.out.println("ok");
         // Get a writer pointer  
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

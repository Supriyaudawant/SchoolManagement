package school_management.hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class ValidationServlet extends HttpServlet
{
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
       {
    	   String email1=req.getParameter("email");
           String password1=req.getParameter("password");
           
           EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
           EntityManager em=emf.createEntityManager();
           
           Query q=em.createQuery("select p from Principal p where email=?1 and password=?2");
           q.setParameter(1, email1);
           q.setParameter(2, password1);
           List<Principal> principal=q.getResultList();
          if(principal.size()>0) 
          {
        	  PrintWriter pw=resp.getWriter();
        	  pw.write("Login Successfully");
        	  RequestDispatcher rd = req.getRequestDispatcher("TSLogin.html");
      		  rd.include(req, resp);
      		  resp.setContentType("text/html");
          }
          else {
        	  PrintWriter pw=resp.getWriter();
        	  pw.write("Invalid Login");
        	  RequestDispatcher rd = req.getRequestDispatcher("Login.html");
     		  rd.include(req, resp);
     		  resp.setContentType("text/html");
        	  
          }
          
    	   
       }
	
	
}

package school_management.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentca")
public class StudentServlet  extends HttpServlet
{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 String id=req.getParameter("id");
     	String name=req.getParameter("name");
     	String stream=req.getParameter("stream");
     	String fee=req.getParameter("fee");
     	
     	int id1=Integer.parseInt(id);
     	double fee1=Double.parseDouble(fee);
     	
     	EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
 		EntityManager em=emf.createEntityManager();
 		EntityTransaction et=em.getTransaction();
 		
 		Student s=new Student();
 		s.setId(id1);
 		s.setName(name);
 		s.setStream(stream);
 		s.setFee(fee1);

 		et.begin();
 		em.persist(s);
         et.commit();
         
         resp.setContentType("text/html");
 		PrintWriter pw = resp.getWriter() ;
 		pw.write("Student added");

        
        RequestDispatcher rd = req.getRequestDispatcher("StudentCrudOp.html");
 		rd.forward(req, resp);

    }
}

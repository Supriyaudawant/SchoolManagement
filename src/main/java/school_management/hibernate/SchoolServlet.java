package school_management.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createaccount")
public class SchoolServlet extends HttpServlet {
     
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name1=req.getParameter("name");
		String age=req.getParameter("age");
		String mobno=req.getParameter("mobno");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        int age1=Integer.parseInt(age);
        long mobno1=Long.parseLong(mobno);
        
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Principal p=new Principal();
		p.setName(name1);
		p.setAge(age1);
		p.setEmail(email);
		p.setPassword(password);
		p.setMobno(mobno1);

		et.begin();
		em.persist(p);
        et.commit();
       
        RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);

	}
	}
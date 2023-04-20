package school_management.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/ViewTeacher")
	public class ViewTeacherServlet extends HttpServlet
	{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id= Integer.parseInt(req.getParameter("id"));
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
			EntityManager em =emf.createEntityManager();	
			Teacher t = em.find(Teacher.class, 1);
			System.out.println(t);
			RequestDispatcher rd = req.getRequestDispatcher("TeacherCrudOp.html");
		    rd.forward(req, resp);
		}

	}


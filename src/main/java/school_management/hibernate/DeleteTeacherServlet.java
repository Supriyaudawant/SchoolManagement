package school_management.hibernate;

import java.io.IOException;

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
@WebServlet("/DeleteTeacher")
public class DeleteTeacherServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("school");
		EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();
		
		Teacher S = EM.find(Teacher.class, id);
		if(S!=null)
		{
		ET.begin();
		EM.remove(S);
		ET.commit();
		}
		else
		{
			System.out.println("Data is not present in database");
		}
		   RequestDispatcher rd = req.getRequestDispatcher("TeacherCrudOp.html");
	        rd.forward(req, resp);
	}
}

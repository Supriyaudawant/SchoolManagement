<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="school_management.hibernate.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<%
  String id=request.getParameter("id");
  int id1=Integer.parseInt(id);
  
  EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
  EntityManager em=emf.createEntityManager();
  
  Student s=em.find(Student.class, id1);
%>
   <form action="updates" method="post" align="center">
  id:<input type="text" value="<%=s.getId()%>" name="id"><br><br>
  Name:<input type="text" value="<%=s.getName()%>" name="name"><br><br>
  Stream:<input type="text" value="<%=s.getStream()%>" name="stream"><br><br>
  Fee:<input type="text" value="<%=s.getFee()%>" name="fee"><br><br>
  <input type="submit">
  </form>

</body>
</html>
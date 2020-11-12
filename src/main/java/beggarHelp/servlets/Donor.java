package beggarHelp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Institution;

public class Donor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Donor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idInstitution = Integer.parseInt(request.getParameter("id")); 
		
        HttpSession session = request.getSession();
        beggarHelp.model.Donor user = (beggarHelp.model.Donor) session.getAttribute("user");
         
		InstitutionDao iDao = new InstitutionDao();
		Institution i = iDao.get(idInstitution);
		i.setDoador(user);
		
		iDao.update(i);
		
		response.sendRedirect("donor.jsp");
	}

}


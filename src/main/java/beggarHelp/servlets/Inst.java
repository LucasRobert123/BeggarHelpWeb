package beggarHelp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beggarHelp.dao.DonorDao;
import beggarHelp.model.Donor;


public class Inst extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Inst() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DonorDao dDao = new DonorDao();
		
		Donor donor = dDao.get(id);
		
		dDao.delete(donor);
		
		response.sendRedirect("institution.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

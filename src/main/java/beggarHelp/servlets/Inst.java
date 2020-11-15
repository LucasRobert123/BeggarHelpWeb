package beggarHelp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;

public class Inst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inst() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String delete = request.getParameter("delete");
		
		if(delete.equals("true")) {
			
			int idInst = Integer.parseInt(request.getParameter("idInst"));
			
			InstitutionDao iDao = new InstitutionDao();
			Institution inst = iDao.get(idInst);
			
			inst.getDoadores().remove(id -1);
					
			iDao.update(inst);
			
			response.sendRedirect("institution.jsp");
		}
		else {
			Donor donor = getDonor(id);
			String json = new Gson().toJson(donor);
	
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static Donor getDonor(int id) {
		
		DonorDao dDao = new DonorDao();
		
		Donor donor = dDao.get(id);
		
		return donor;
	}
}

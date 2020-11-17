package beggarHelp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Institution;

public class Donor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Donor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
      String list = request.getParameter("list");
      String json = "";
      
      if(request.getParameter("uf") != null && request.getParameter("city") != null 
    		 && !request.getParameter("uf").isEmpty() && !request.getParameter("uf").isEmpty()
        ) {
    	  
    	 List<Institution> donors = new ArrayList<Institution>();
    	 InstitutionDao dDao = new InstitutionDao();
    	 
    	 String uf = request.getParameter("uf");
    	 String city = request.getParameter("city");
    	 donors = dDao.filterInstitution(uf, city);

    	 json = new Gson().toJson(donors);
      }
      else if(list != null && list.equals("true") && request.getParameter("details") != "true") {
    	  List<Institution> listInst = new ArrayList<Institution>();
    	    
		  InstitutionDao iDao = new InstitutionDao();
	      listInst.addAll(iDao.getAll());
	      
	      json = new Gson().toJson(listInst);
      }
	  else if(request.getParameter("details").equals("true")){
	
		int id = Integer.parseInt(request.getParameter("id"));

		Institution inst = getInstitution(id);
		json = new Gson().toJson(inst);

		
	  }
      
      response.setContentType("application/json");
	  response.setCharacterEncoding("UTF-8");
	  response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		int idInstitution = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		beggarHelp.model.Donor user = (beggarHelp.model.Donor) session.getAttribute("user");

		InstitutionDao iDao = new InstitutionDao();
		Institution i = iDao.get(idInstitution);
		
		user.setListIdsInstitutionsPendente(idInstitution);
		DonorDao dDao = new DonorDao();
		
		dDao.update(user);
		
		i.setDoador(user);
		iDao.update(i);

		response.sendRedirect("donor.jsp");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static Institution getInstitution(int id) {

		InstitutionDao iDao = new InstitutionDao();

		Institution inst = iDao.get(id);

		return inst;
	}
}

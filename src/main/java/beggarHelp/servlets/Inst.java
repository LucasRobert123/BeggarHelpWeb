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
			String details = request.getParameter("details");
            String json = "";
			if (delete != null && delete.equals("true")) {

				try {
					int idInst = Integer.parseInt(request.getParameter("idInst"));
					
					//Excluindo da list de pendente
					   
					 removeListPendentes(id, idInst);
					
					//Excluindo doador da lista de doadores da instituição
					
					Institution inst = deleteDonorFromListInstitution(id, idInst);
					
					//retornando list depois de excluir
					List<Donor> list = new ArrayList<Donor>();
					list.addAll(inst.getDoadores());
					
					json = new Gson().toJson(list);
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
            } else if (details != null && details.equals("true")) {
            	
            	// Mandar dados para mostrar no modal detalhes do doador
				Donor donor = getDonor(id);
				json = new Gson().toJson(donor);
			}
            else if(request.getParameter("listDonors").equals("true")) {
            	
            	// retornando lista de doadores insteressados em doar em determinada instituição
            	InstitutionDao iDao = new InstitutionDao();
            	List<Donor> list = new ArrayList<Donor>();
            	
            	list.addAll(iDao.get(id).getDoadores());
            	
            	json = new Gson().toJson(list);
            }
			
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static Donor getDonor(int id) {

		DonorDao dDao = new DonorDao();

		Donor donor = dDao.get(id);

		System.out.println(donor);
		return donor;
	}
	
	private static void removeListPendentes(int id, int idInst) {
		DonorDao dDao  = new DonorDao();
		Donor donor = dDao.get(id);
		
		donor.getListIdsInstitutionsPendente().remove(new Integer(idInst));
		
		dDao.update(donor);
	}
	
	private static Institution deleteDonorFromListInstitution(int id, int idInst) {
		InstitutionDao iDao = new InstitutionDao();
		Institution inst = iDao.get(idInst);

		if(inst.getDoadores().size() == 1)
			inst.getDoadores().remove(0);
		else {
		  inst.getDoadores().remove(id - 1);
		}
		iDao.update(inst);
		
		return inst;
	}
}

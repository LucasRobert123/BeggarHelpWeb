package beggarHelp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");


		if (user != null && user.equals("institution")) {
			
           saveInstitution(request);
           
		}
		else if (user != null && user.equals("donor")) { 
			
			saveDonor(request);
			
		}

		response.sendRedirect("index.jsp");
	}
	
	private static void saveInstitution(HttpServletRequest request) {
		Institution inst = new Institution();

		inst.setName(request.getParameter("name"));
		inst.setPhone(request.getParameter("phone"));
		inst.setEmail(request.getParameter("email"));
		inst.setPassword(request.getParameter("password"));
		inst.setNeighborhood(request.getParameter("neighborhood"));
		inst.setStreet(request.getParameter("street"));
		inst.setNumber(request.getParameter("number"));
		inst.setCity(request.getParameter("city"));
		inst.setUf(request.getParameter("uf"));
		inst.setCnpj(request.getParameter("cnpj"));
		inst.setDescription(request.getParameter("description"));
		
		InstitutionDao instDao = new InstitutionDao();
		instDao.save(inst);
	}
	
	private static void saveDonor(HttpServletRequest request) {
		Donor donor = new Donor();

		donor.setName(request.getParameter("name"));
		donor.setPhone(request.getParameter("phone"));
		donor.setEmail(request.getParameter("email"));
		donor.setPassword(request.getParameter("password"));
		donor.setNeighborhood(request.getParameter("neighborhood"));
		donor.setStreet(request.getParameter("street"));
		donor.setNumber(request.getParameter("number"));
		donor.setCity(request.getParameter("city"));
		donor.setUf(request.getParameter("uf"));
		donor.setCpf(request.getParameter("cpf"));

		DonorDao donorDao = new DonorDao();
		donorDao.save(donor);
	}

}

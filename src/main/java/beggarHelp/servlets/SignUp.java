package beggarHelp.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Alert;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;
import beggarHelp.model.User;

import static javax.swing.JOptionPane.showMessageDialog;

@MultipartConfig

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

		try {
			//String path = request.getSession().getServletContext().getRealPath("/");
			
			
			String fileName = saveImageUpload(request);
			
			String user = request.getParameter("user");
		
			Boolean save = false;
		
			if (user != null && user.equals("institution")) {
				
	            save = saveInstitution(request, fileName);
		       
			}
			else if (user != null && user.equals("donor")) { 
				
				save = saveDonor(request, fileName);
				
			}
			
			
			if(save)
			   response.sendRedirect("sucess_sign_up.jsp");
			else {
				response.sendRedirect("sign_up.jsp");
			}
		}
		catch(Exception e) {
			Alert.alertSimple("Ocorreu um erro! Tente novamente mais tarde");
		}
	}
	
	private static void setDataNotEspecific(HttpServletRequest request, User obj) {
		obj.setName(request.getParameter("name"));
		obj.setPhone(request.getParameter("phone"));
		obj.setEmail(request.getParameter("email"));
		obj.setPassword(request.getParameter("password"));
		obj.setNeighborhood(request.getParameter("neighborhood"));
		obj.setStreet(request.getParameter("street"));
		obj.setNumber(request.getParameter("number"));
		obj.setCity(request.getParameter("city"));
		obj.setUf(request.getParameter("uf"));
	}
	
	private static Boolean saveInstitution(HttpServletRequest request, String fileName) {
		
		Institution inst = new Institution();
		InstitutionDao instDao = new InstitutionDao();
		
		String email = request.getParameter("email");
		String cnpj = request.getParameter("cnpj");
		
		if(instDao.checkIfThereIsAUserWithThatEmail(email, cnpj)) {
			setDataNotEspecific(request, inst);
			
			inst.setCnpj(request.getParameter("cnpj"));
			inst.setDescription(request.getParameter("description"));
			inst.setProfilePicture(fileName);
		   
			instDao.save(inst);
			
			return true;
		}
		else {
			Alert.alertSimple("Instituição ja existente!");
            return false;
		}
	}
	
	private static Boolean saveDonor(HttpServletRequest request, String fileName) {
		
		DonorDao donorDao = new DonorDao();
		
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		
		if(donorDao.checkIfThereIsAUserWithThatEmail(email,cpf)) {
			Donor donor = new Donor();
	
			setDataNotEspecific(request, donor);
			
			donor.setCpf(request.getParameter("cpf"));
			donor.setProfilePicture(fileName);
	        
			donorDao.save(donor);
			return true;
		}
		else {
			Alert.alertSimple("Doador ja existente!");
            return false;
		}
	}
	

	private static String saveImageUpload(HttpServletRequest request) {
		String str = "C:\\Users\\Lucas\\Documents\\Faculdade\\6_periodo\\Linguagem_e_Tecnicas_de_Programacao\\Projetos\\BeggarHelpWeb\\src\\main\\webapp\\images";
		
		String fileName = "";
		File uploadDir = new File(str);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		
		try {
			
			for(Part part : request.getParts())
			{
			    if(part.getName().equals("file")) {
					InputStream is =  part.getInputStream();
					fileName = part.getSubmittedFileName();
					Files.copy(is, new File(str,fileName).toPath());
			    }
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		}
		
		return fileName;
	}
}
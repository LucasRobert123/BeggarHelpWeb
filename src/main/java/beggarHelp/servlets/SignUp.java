package beggarHelp.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;
import beggarHelp.model.User;


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

		String path = request.getSession().getServletContext().getRealPath("/");
		
		
		String fileName = saveImageUpload(request);
		System.out.println(fileName);
		
		String user = request.getParameter("user");


		if (user != null && user.equals("institution")) {
			
           saveInstitution(request, fileName);
           
		}
		else if (user != null && user.equals("donor")) { 
			
			saveDonor(request, fileName);
			
		}

		response.sendRedirect("index.jsp");
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
	
	private static void saveInstitution(HttpServletRequest request, String fileName) {
		Institution inst = new Institution();

		setDataNotEspecific(request, inst);
		
		inst.setCnpj(request.getParameter("cnpj"));
		inst.setDescription(request.getParameter("description"));
	    inst.setStatus("active");
		inst.setProfilePicture(fileName);
	    
		InstitutionDao instDao = new InstitutionDao();
		instDao.save(inst);
	}
	
	private static void saveDonor(HttpServletRequest request, String fileName) {
		Donor donor = new Donor();

		setDataNotEspecific(request, donor);
		
		donor.setCpf(request.getParameter("cpf"));
        donor.setStatus("active");
		donor.setProfilePicture(fileName);
        
		DonorDao donorDao = new DonorDao();
		donorDao.save(donor);
	}

	private static String saveImageUpload(HttpServletRequest request) {
		String str = "C:\\Users\\Lucas\\Documents\\Faculdade\\6_periodo\\Linguagem_e_Tecnicas_de_Programacao\\Projetos\\BeggarHelpWeb\\src\\main\\webapp\\images";
		
		String fileName = "";
		File uploadDir = new File(str);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		
		try {
			for(Part part : request.getParts()){
			    
			    if(part.getName().equals("file")) {
					InputStream is =  part.getInputStream();
					fileName = part.getSubmittedFileName();
					Files.copy(is, new File(str,fileName).toPath());
				    
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
}
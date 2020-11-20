package beggarHelp.servlets;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import beggarHelp.dao.Dao;
import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Alert;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;
import beggarHelp.model.User;
import static javax.swing.JOptionPane.showMessageDialog;

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignIn() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String user = request.getParameter("user");
		String check = "";
		Boolean logged = false;

		// verificando se o usuário marcou o checkbox Lembrar-me
		if (request.getParameter("check") != null) {
			check = request.getParameter("check");
			logged = check.equals("on") ? true : false;
		}

		try {
				if (user != null && user.equals("institution")) {
	
					// fazendo login de Institution
					
					loginInstitution(request, response, email, password, logged);
					
				} 
				else if (user != null && user.equals("donor")) {
	                
					// fazendo login de doador
					loginDoador(request, response, email, password, logged);
		           			
				}
				 response.sendRedirect("index.jsp");
            } 
		    catch (Exception e) {
	    	    Alert.alertSimple("Ocorreu um erro ao logar! Confira suas credenciais, tente novamente.");
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private static void loginInstitution(HttpServletRequest request, HttpServletResponse response ,String email, String password, Boolean logged) throws IOException {
		
		InstitutionDao inst = new InstitutionDao();
		List<Institution> list = new ArrayList<Institution>();

		list.addAll(inst.logar(email, password));

		HttpSession session = request.getSession();
		session.setAttribute("user", list.get(0));

		if (logged == true)
			session.setAttribute("typeUser", "institution.jsp");

		if (list.size() == 1)
			response.sendRedirect("institution.jsp");
			
	}
	
    private static void loginDoador(HttpServletRequest request, HttpServletResponse response ,String email, String password, Boolean logged) throws IOException {
		
    	DonorDao donor = new DonorDao();
		List<Donor> list = new ArrayList<Donor>();

		list.addAll(donor.logar(email, password));

		HttpSession session = request.getSession();
		session.setAttribute("user", list.get(0));

		if (logged == true)
			session.setAttribute("typeUser", "donor.jsp");

		if (list.size() == 1)
			response.sendRedirect("donor.jsp");
			
	}
    

}
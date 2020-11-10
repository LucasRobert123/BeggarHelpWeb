package beggarHelp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import beggarHelp.dao.DonorDao;
import beggarHelp.dao.InstitutionDao;
import beggarHelp.model.Donor;
import beggarHelp.model.Institution;

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
		

		if(user != null && user.equals("institution")) {
			
			InstitutionDao inst = new InstitutionDao();
			List<Institution> list = new ArrayList<Institution>();
			
			list.addAll(inst.logar(email, password));
			
			
			HttpSession session =  request.getSession();
			session.setAttribute("user", list.get(0));
			
			if(list.size() == 1)
			  response.sendRedirect("institution.jsp");
		}
		else if(user != null && user.equals("donor")) {
			
			DonorDao inst = new DonorDao();
			List<Donor> list = new ArrayList<Donor>();
			
			list.addAll(inst.logar(email, password));
			//System.out.println(list.get(0));
			
			HttpSession session =  request.getSession();
			session.setAttribute("user", list.get(0));
			
			if(list.size() == 1)
			  response.sendRedirect("donor.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
	}
	
	

}

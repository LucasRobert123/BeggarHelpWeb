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
import beggarHelp.model.Donor;

public class Inst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inst() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		Donor donor = getDonor(id);
		String json = new Gson().toJson(donor);

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
		
		return donor;
	}
}

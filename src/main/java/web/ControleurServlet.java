package web;

import java.io.IOException;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControleurServlet extends HttpServlet {
	private IProduitDao metier;
	@Override
	public void init() throws ServletException {
		 metier =new ProduitDaoImpl();
		 
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		request.getRequestDispatcher("produits.jsp").forward(request, responce);
	}
	

}

package web;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;

@WebServlet(name="cs",urlPatterns= {"*.do"})
public class ControleurServlet extends HttpServlet {
	private IProduitDao metier;
	@Override
	public void init() throws ServletException {
		 metier =new ProduitDaoImpl();
		 
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.do")){
			System.out.print("hhhhh");
			request.getRequestDispatcher("produits.jsp").forward(request, responce);

		}
		
		else if(path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ProduitModel model =new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits=metier.ProduitsParMC("%"+motCle+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, responce);	
		}
		else if(path.equals("/add.do")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("add.jsp").forward(request, responce);	

		}
		else if(path.equals("/addProduct.do") &&(request.getMethod().equals("POST"))) {
			String ds=request.getParameter("Designation");
		    Long prix= Long.parseLong(request.getParameter("Prix"));
			Long quantite= Long.parseLong(request.getParameter("Quantite"));

			Produit p=metier.save(new Produit(ds,prix,quantite));
			System.out.println(p.getPrix());
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, responce);	

			
		}
		else if(path.equals("/editProduct.do") &&(request.getMethod().equals("POST"))) {
			Long id=Long.parseLong(request.getParameter("id"));
			String ds=request.getParameter("Designation");
		    Long prix= Long.parseLong(request.getParameter("Prix"));
			Long quantite= Long.parseLong(request.getParameter("Quantite"));

			Produit p=new Produit(ds,prix,quantite);
			p.setId(id);
			metier.update(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, responce);	

		

			
		}
		else if(path.equals("/delete.do")){
			Long id=Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produits.jsp").forward(request, responce);	
			responce.sendRedirect("chercher.do?motCle= ");	
		}
		else if(path.equals("/edit.do")){
			Long id=Long.parseLong(request.getParameter("id"));
			Produit p=metier.getProduit(id);
			request.setAttribute("produit",p);
			request.getRequestDispatcher("editProduct.jsp").forward(request, responce);	

			
			
		}
		
		else {
			responce.sendError(Response.SC_NOT_FOUND);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

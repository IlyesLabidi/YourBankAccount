package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.Produit;

/**
 * Servlet implementation class ControlleurServlet
 */
@WebServlet("/ControlleurServlet")
public class ControlleurServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICatalogueMetier metier;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		metier= new CatalogueMetierImpl();
	}
    public ControlleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//this.getServletContext().getRequestDispatcher("/WEB-INF/vueproduits.jsp").forward(request, response);
         doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ProduitModel model =new ProduitModel();
		request.setAttribute("model", model);// c la mem si on fait onpas on est entrain de modifier objet model qui est dans request
		String action =request.getParameter("action");
		if(action!=null){
			if(action.equals("chercher")){
				
				model.setMotcle(request.getParameter("motcle"));
				List<Produit> produits=metier.ProduitParMc(model.getMotcle());
				model.setProduits(produits);
				
				}else if (action.equals("delete")){
					String ref=request.getParameter("ref");
					metier.deleteProduit(ref);
					model.setProduits(metier.listProduits());
				}
				else if (action.equals("edit")){
					String ref=request.getParameter("ref");
					Produit p= metier.getProduit(ref);
					model.setProduit(p);
					model.setMode("edit");
					
					model.setProduits(metier.listProduits());
				}
				
				else if (action.equals("save")){
					try{
					model.getProduit().setReference(request.getParameter("reference"));
					model.getProduit().setDesignation(request.getParameter("designation"));
					model.getProduit().setPrix(Double.parseDouble( request.getParameter("prix")));
					model.getProduit().setQuantite(Integer.parseInt(request.getParameter("quantite")));
					model.setMode(request.getParameter("mode"));
					
					if(model.getMode().equals("ajout"))
					metier.addproduit(model.getProduit());
					else if (model.getMode().equals("edit"))
						metier.updateProduit(model.getProduit());
					
					model.setProduits(metier.listProduits());
					}catch(Exception e){
						model.setError(e.getMessage());
						
					}
				}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueproduits.jsp").forward(request, response);
		
	}

}

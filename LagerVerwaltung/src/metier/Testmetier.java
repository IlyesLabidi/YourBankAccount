package metier;

import java.util.List;

public class Testmetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICatalogueMetier metier= new CatalogueMetierImpl();
		/*metier.addproduit(new Produit("PR04", "AA", 205, 6));
		metier.addproduit(new Produit("PR05", "BB", 25, 3));
		metier.addproduit(new Produit("PR06", "CC", 75, 4)); */
		List<Produit> prods= metier.listProduits();
		
		for(Produit p:prods){
			System.out.println(p.getDesignation());
		}
		
		System.out.println("------------------------------");
   List<Produit> prods2= metier.ProduitParMc("HP");
		
		for(Produit p:prods2){
			System.out.println(p.getDesignation());
		}
		
		System.out.println("------------------------------");
		try {
			
		 Produit p= metier.getProduit("PR02");
		System.out.println(p.getDesignation()+" "+p.getPrix()+"$");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		try {
			
		 Produit p= metier.getProduit("PR02");
		 p.setPrix(120);
		 metier.updateProduit(p);
		System.out.println(p.getDesignation()+" "+p.getPrix()+"$");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		metier.deleteProduit("PR04");
		System.out.println("produit a ete supprimer");
		
	
	}

}

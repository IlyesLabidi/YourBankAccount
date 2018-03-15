package metier;

import java.util.List;

public interface ICatalogueMetier {
	
	public void addproduit(Produit p);
	public List<Produit> listProduits ();
	public List<Produit> ProduitParMc(String mc);
	public Produit getProduit(String ref);
	public void updateProduit(Produit p);
	public void deleteProduit(String ref);
	
	
}

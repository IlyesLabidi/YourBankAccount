package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogueMetier{

	@Override
	public void addproduit(Produit p) {
		// TODO Auto-generated method stub
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedtatement= connection.prepareStatement("INSERT INTO produits(REF_PROD,DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?,?)");
			preparedtatement.setString(1,p.getReference());
			preparedtatement.setString(2,p.getDesignation());
			preparedtatement.setDouble(3,p.getPrix());
			preparedtatement.setInt(4,p.getQuantite());
			preparedtatement.executeUpdate();
			preparedtatement.close();
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		List<Produit> prods = new ArrayList<Produit>();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from produits");
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()){
				Produit p= new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
		preparedstatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prods;
	}

	@Override
	public List<Produit> ProduitParMc(String mc) {
		List<Produit> prods = new ArrayList<Produit>();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from produits where DESIGNATION like ? ");
			preparedstatement.setString(1, "%"+mc+"%");
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()){
				Produit p= new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
		preparedstatement.close();
		}catch (SQLException e) {
			// TODO Auto-generat ed catch block
			e.printStackTrace();
		}
		
		return prods;
	}

	@Override
	public Produit getProduit(String ref) {
		Produit p= null;
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from produits where REF_PROD=? ");
			preparedstatement.setString(1, ref);
			ResultSet rs = preparedstatement.executeQuery();
			
				if(rs.next()){
			    p=new Produit() ; 
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				}
		preparedstatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p==null) throw new RuntimeException("produit"+ref+" introuvable");//exception non surveille n'est pas signaler par le compilateur  
		return p;
	
	}

	@Override
	public void updateProduit(Produit p) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedtatement= connection.prepareStatement("update produits set DESIGNATION=?, PRIX=?, QUANTITE=? where REF_PROD=?");
			
			preparedtatement.setString(1,p.getDesignation());
			preparedtatement.setDouble(2,p.getPrix());
			preparedtatement.setInt(3,p.getQuantite());
			preparedtatement.setString(4,p.getReference());
			preparedtatement.executeUpdate();
			preparedtatement.close();
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduit(String ref) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedtatement= connection.prepareStatement("delete from produits  where REF_PROD=?");
			
			preparedtatement.setString(1,ref);
			preparedtatement.executeUpdate();
			preparedtatement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}

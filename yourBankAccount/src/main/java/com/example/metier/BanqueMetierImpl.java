package com.example.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CompteRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;

@Service                                                   //pour que spring puisse instancier cette classe au demarage
@Transactional                                          // elle est (service)utiliser par les objet des couche metier
public class BanqueMetierImpl implements IBanqueMetier {                    // toute les methode sont transactionelle c a dire soit tt les fonction se fait correctement sit on annule tout
    @Autowired
	private CompteRepository compteRepository ;
    @Autowired
    private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp= compteRepository.findOne(codeCpte);
		if(cp==null)throw new RuntimeException("compte introuvable"); // c est une exception qui n est pas suivable
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp= compteRepository.findOne(codeCpte);
		Versement V = new Versement(new Date(), montant, cp);
		operationRepository.save(V);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
	
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp= compteRepository.findOne(codeCpte);
		double faciliteCaisse=0;
		if(cp instanceof CompteCourant)
			faciliteCaisse=((CompteCourant) cp).getDecouvert();
		if((cp.getSolde()+faciliteCaisse)<montant)
			throw new RuntimeException("solde insuffisant");
			
		Retrait R = new Retrait(new Date(), montant, cp);
		operationRepository.save(R);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)) throw new RuntimeException("impossible d'effectuer un virement sur le meme compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listOpertation
				(codeCpte, new PageRequest(page, size));
	

}
}

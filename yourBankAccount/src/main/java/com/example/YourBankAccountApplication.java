package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.dao.ClientRepository;
import com.example.dao.CompteRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;
import com.example.entities.Retrait;
import com.example.entities.Versement;
import com.example.metier.IBanqueMetier;

@SpringBootApplication(scanBasePackages = { "com.example.dao", "com.example.metier", "com.example.web","com.example.security"})
@EnableJpaRepositories("com.example.dao")
public class YourBankAccountApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	
	
	
	public static void main(String[] args) {
		
	/*ApplicationContext ctx=	*/ SpringApplication.run(YourBankAccountApplication.class, args);
	//ClientRepository clientRepository=ctx.getBean(ClientRepository.class);
	//clientRepository.save(new Client("ilyes", "ilyesab@yahoo.de"));
	
}


	@Override
	public void run(String... arg0) throws Exception {
		//System.getProperties().put( "server.port", 8080 );
		/*Client c1= clientRepository.save(new Client("ilyes", "ilyesab@yahoo.de"));  
		Client c2= clientRepository.save(new Client("oues", "oues@yahoo.de"));
		
		Compte cp1=compteRepository.save(new CompteCourant("c1", new Date(), 900000.0, c1, 6000.0));
		Compte cp2=compteRepository.save(new CompteEpargne("c2", new Date(), 6000.0, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 200.0, cp1));
		operationRepository.save(new Versement(new Date(), 100.0, cp2));
		operationRepository.save(new Versement(new Date(), 300.0, cp2));
		
		operationRepository.save(new Retrait(new Date(), 100.0, cp2));
		banqueMetier.verser("c1", 111);*/
		
		
		
		
		
		
		
	}
}

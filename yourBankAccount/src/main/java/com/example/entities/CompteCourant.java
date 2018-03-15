package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")// c a dire que ci le compte est courant , "cc" va s ecrire dans lattribut Type_CPTE
public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String codeCompte, Date dateCreation, Double solde, Client client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	

}

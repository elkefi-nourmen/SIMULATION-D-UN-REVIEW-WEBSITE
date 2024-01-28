package user;

import java.util.Scanner;
public class elements {
public elements(String nom_complet) {
		super();
		this.nom_complet = nom_complet;
	}
public elements() {
	super();
	this.nom_complet = "";
}

private String nom_complet;

public String getNom_complet() {
	return nom_complet;
}

public void setNom_complet(String nom_complet) {
	this.nom_complet = nom_complet;
}
Scanner s=new Scanner(System.in);
public void saisir ()
{
	System.out.println("Saisir un nom complet");
	nom_complet=s.next();
}
public void afficher ()
{
	System.out.println("Nom complet : "+nom_complet);


}
}

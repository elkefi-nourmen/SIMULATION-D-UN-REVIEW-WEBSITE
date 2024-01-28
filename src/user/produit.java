package user;

import java.util.Scanner;
import java.util.Objects;


public class produit extends elements{
public produit(String nom_complet, String categorie, String marque) {
		super(nom_complet);
		this.categorie = categorie;
		this.marque = marque;
	}
public produit() {
	super();
	this.categorie = "";
	this.marque = "";
}

private String categorie ;
private String marque;
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
Scanner s=new Scanner(System.in);
public void saisir()
{   
	super.saisir();
	System.out.println("saisissez la categorie du produit");
	categorie=s.nextLine();
	System.out.println("saisissez la marque du produit");
	marque=s.nextLine();
	
}
public void afficher ()
{
	super.afficher();
	System.out.println("Categorie : "+categorie);
	System.out.println("Marque : "+marque);

 

}
@Override
public String toString() {
    return "Categorie: " + this.getCategorie() + ", Nom complet: " + this.getNom_complet() + ", Marque: " + this.getMarque();
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    produit produit = (produit) o;
    return Objects.equals(getNom_complet(), produit.getNom_complet()) &&
            Objects.equals(getCategorie(), produit.getCategorie()) &&
            Objects.equals(getMarque(), produit.getMarque());
}

@Override
public int hashCode() {
    return Objects.hash(getNom_complet(), getCategorie(), getMarque());
}
}


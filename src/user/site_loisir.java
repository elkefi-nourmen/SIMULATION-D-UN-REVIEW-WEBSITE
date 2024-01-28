package user;

import java.util.Objects;

public class site_loisir extends elements {
public site_loisir(String nom_complet, String ville, String pays, String type) {
		super(nom_complet);
		this.ville = ville;
		this.pays = pays;
		this.type = type;
	}
public site_loisir(){
	super();
	this.ville = "";
	this.pays = "";
	this.type = "";
}
private String ville ;
private String pays;
private String type;
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public void saisir()
{   
	super.saisir();
	System.out.println("saisissez la ville ");
	 ville=s.next();
	System.out.println("saisissez le nom du pays");
	pays=s.next();
	System.out.println("saisissez le type");
	type=s.next();
	
}
public void afficher ()
{
	super.afficher();
	System.out.println("Ville : "+ville);
	System.out.println("Pays : "+pays);
	System.out.println("Type : "+type);



}
@Override
public String toString() {
    return "Nom complet: " + this.getNom_complet() + ", Pays: " + this.getPays() + ", Ville: " + this.getVille()+ ", Type :"+this.getType();
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    site_loisir site = (site_loisir) o;
    return Objects.equals(getNom_complet(), site.getNom_complet()) &&
            Objects.equals(getPays(), site.getPays()) &&
            Objects.equals(getVille(), site.getVille())
            && Objects.equals(getType(), site.getType());
}

@Override
public int hashCode() {
    return Objects.hash(getNom_complet(), getPays(), getVille());
}
}

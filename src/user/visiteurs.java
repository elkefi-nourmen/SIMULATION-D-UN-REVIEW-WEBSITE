package user;
import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;
public class visiteurs {
	
public visiteurs(String nom, String tel, String mail) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
	}

public visiteurs() {
		super();
		this.nom = "";
		this.tel = "";
		this.mail = "";
	}
private String nom;
private String tel;
private String mail;

Scanner s=new Scanner(System.in);
public void saisir()
{   
	String emailtype = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    while (!(nom.matches("[a-zA-Z]+"))){
	System.out.println("Saisissez votre nom");	
	nom=s.next();}
	while (!(tel.matches("[0-9]+"))|| tel.length()!=8) {
	System.out.println("Saisissez votre numero de telephone");	
	tel=s.next();}
	while (!(Pattern.matches(emailtype, mail))) {
	System.out.println("Saisissez votre e mail");	
	mail=s.next();}
}

public void afficher ()
{
	System.out.println("nom: "+nom);
	System.out.println("numero de telephone: "+tel);
	System.out.println("e mail: "+mail);


}

public void publier(avis a, review_site rs) {
    a.setNom(nom);
    char c = ' ';

    // controle de saisie
    while (Character.toLowerCase(c) != 'p' && Character.toLowerCase(c) != 's') {
        System.out.println("Saisissez la categorie de cet objet : P s'il est un produit et S s'il est un site de loisirs");
        c = s.next().charAt(0);
    }

    if (Character.toLowerCase(c) == 'p') {
        a.setObj_eval(new produit());
        a.getObj_eval().saisir();

        produit prodKey = (produit) a.getObj_eval();

        // Check if the produit exists in avprod
        if (rs.getAvprod().containsKey(prodKey)) {
            rs.getAvprod().get(prodKey).add(a);
        } else {
            // If the produit doesn't exist, add it to avprod
            ArrayList<avis> avisList = new ArrayList<>();
            avisList.add(a);
            rs.getAvprod().put(prodKey, avisList);
        }
    } else {
        a.setObj_eval(new site_loisir());
        a.getObj_eval().saisir();

        site_loisir siteKey = (site_loisir) a.getObj_eval();

        // Check if the site exists in avsite
        if (rs.getAvsite().containsKey(siteKey)) {
            rs.getAvsite().get(siteKey).add(a);
        } else {
            // If the site doesn't exist, add it to avsite
            ArrayList<avis> avisList = new ArrayList<>();
            avisList.add(a);
            rs.getAvsite().put(siteKey, avisList);
        }
    }

    float x = -1;
    while (x > 5 || x < 0) {
        System.out.println("Donnez votre note :");
        x = s.nextFloat();
    }
    a.setNote(x);

    System.out.println("Saisissez votre commentaire :");
    String comm = s.next();
    a.setCommentaire(comm);
}





public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}

}

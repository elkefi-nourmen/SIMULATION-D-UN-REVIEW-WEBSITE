package user;
import java.util.*;
public class avis {
public avis(String nom, elements obj_eval, float note, String commentaire) {
		super();
		this.nom = nom;
		this.obj_eval = obj_eval;
		this.note = note;
		this.commentaire = commentaire;
	}

public avis() {
	super();
	this.nom="";
	this.obj_eval = new elements();
	this.note = 0;
	this.commentaire = "";
}
private String nom;
private elements obj_eval;
private float note ;
private String commentaire;


public void  afficher()
{
	System.out.println("Nom :"+ nom);
	System.out.println("Objet à évaluer :");
	obj_eval.afficher();
	System.out.println("Note :"+ note);
	System.out.println("Commentaire :"+commentaire);
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public elements getObj_eval() {
	return obj_eval;
}

public void setObj_eval(elements obj_eval) {
	this.obj_eval = obj_eval;
}

public float getNote() {
	return note;
}

public void setNote(float note) {
	this.note = note;
}

public String getCommentaire() {
	return commentaire;
}

public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}

@Override
public String toString() {
    return "Utilisateur: " + this.getNom() + ", Note: " + this.getNote() + ", Commentaire: " + this.getCommentaire();
}

}





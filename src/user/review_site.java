package user;

import java.util.*;



public class review_site 
{
	
	 public review_site(HashMap<produit, ArrayList<avis>> avprod, HashMap<site_loisir, ArrayList<avis>> avsite,
			ArrayList<visiteurs> util, ArrayList<admin> administrateur) {
		super();
		this.avprod = avprod;
		this.avsite = avsite;
		this.util = util;
		this.administrateur = administrateur;
	}
	HashMap <produit,ArrayList<avis>> avprod=new HashMap<>();
	 HashMap <site_loisir,ArrayList<avis>> avsite=new HashMap<>();
	 ArrayList <visiteurs> util=new ArrayList<>();
	 ArrayList <admin> administrateur=new ArrayList<>();
	  
	// afficher les avis d un produit donnee 
	 public void afficherAvisProduit(produit produitRecherche) {
		    System.out.println("Avis pour le produit " + produitRecherche + ":");

		    if (avprod.containsKey(produitRecherche)) {
		        ArrayList<avis> avisProduit = avprod.get(produitRecherche);

		        if (avisProduit.isEmpty()) {
		            System.out.println("Aucun avis disponible pour ce produit");
		        } else {
		            for (avis avisCourant : avisProduit) {
		                avisCourant.afficher();
		            }
		        }
		    } else {
		        System.out.println("Le produit " + produitRecherche + " n'existe pas ");
		    }
		}

	 //afficher les avis d'un site donnée 
	
	 public void afficherAvisSite(site_loisir siteRecherche) {
		    System.out.println("Avis pour le site de loisir " + siteRecherche + ":");

		    if (avsite.containsKey(siteRecherche)) {
		        ArrayList<avis> avisSite = avsite.get(siteRecherche);

		        if (avisSite.isEmpty()) {
		            System.out.println("Aucun avis disponible pour ce site de loisir.");
		        } else {
		            for (avis avisCourant : avisSite) {
		                avisCourant.afficher();
		            }
		        }
		    } else {
		        System.out.println("Le site de loisir " + siteRecherche + " n'existe pas ");
		    }
		}

	 // afficher tous les produits et leurs avis 
	
	 public void afficherTousLesAvisProduit() {
		    System.out.println("Tous les avis pour les produits :");

		    if (avprod.isEmpty()) {
		        System.out.println("Aucun produit disponible.");
		        return;
		    }

		    Iterator<produit> produitIterator = avprod.keySet().iterator();
		    while (produitIterator.hasNext()) {
		        produit produitCourant = produitIterator.next();
		        ArrayList<avis> avisProduit = avprod.get(produitCourant);
 
		        System.out.println("Produit : " + produitCourant);
		        System.out.println("Avis :");

		        if (avisProduit.isEmpty()) {
		            System.out.println("Aucun avis disponible pour ce produit.");
		        } else {
		            for (int i = 0; i < avisProduit.size(); i++) {
		                System.out.println(avisProduit.get(i));
		            }
		        }

		        System.out.println("-----------------------------");
		    }
		}

// afficher tous les sites et les avis
	 public void afficherTousLesAvisSite() {
		    System.out.println("Tous les avis pour les sites de loisir :");

		    if (avsite.isEmpty()) {
		        System.out.println("Aucun site de loisir disponible.");
		        return;
		    }

		    Iterator<site_loisir> siteIterator = avsite.keySet().iterator();
		    while (siteIterator.hasNext()) {
		        site_loisir siteCourant = siteIterator.next();
		        ArrayList<avis> avisSite = avsite.get(siteCourant);

		        System.out.println("Site de loisir : " + siteCourant);
		        System.out.println("Avis :");

		        if (avisSite.isEmpty()) {
		            System.out.println("Aucun avis disponible pour ce site de loisir.");
		        } else {
		            for (int i = 0; i < avisSite.size(); i++) {
		                System.out.println(avisSite.get(i));
		            }
		        }

		        System.out.println("-----------------------------");
		    }
		}

	 
	 // delete les avis avec des mots indesirables 
	 public void supprimerAvisIndesirable(String motIndesirable) {
		    if (avprod.isEmpty()) {
		        System.out.println("Aucun produit disponible.");
		    } else {
		        for (ArrayList<avis> avisProduit : avprod.values()) {
		            Iterator<avis> iterator = avisProduit.iterator();
		            while (iterator.hasNext()) {
		                avis avisCourant = iterator.next();
		                // Convertir à la fois le commentaire et le mot indésirable en minuscules pour une comparaison insensible à la casse
		                String commentaire = avisCourant.getCommentaire().toLowerCase();
		                String motIndesirableLower = motIndesirable.toLowerCase();

		                if (commentaire.contains(motIndesirableLower)) {
		                    iterator.remove();
		                    System.out.println("Avis supprimé en raison d'un commentaire indécent ou violent.");
		                }
		            }
		        }
		    }
		}

	


	 // afficher les statistiques du site 

            public void statistics() {
                int totalAvis = 0;
                int totalAvisProduit = 0;
                int totalAvisSite = 0;

                // Nombre total d'avis postés
                // Iterate through avprod HashMap
                Iterator<produit> avprodIterator = avprod.keySet().iterator();
                while (avprodIterator.hasNext()) {
                    produit key = avprodIterator.next();
                    int nbAvisProduit = avprod.get(key).size();
                    totalAvis += nbAvisProduit;
                    totalAvisProduit += nbAvisProduit;

                    // Afficher le nom du produit et le nombre d'avis associé
                    System.out.println("Produit : " ); key.afficher(); System.out.println(", Nombre d'avis : " + nbAvisProduit);
                }

                // Iterate through avsite HashMap
                Iterator<site_loisir> avsiteIterator = avsite.keySet().iterator();
                while (avsiteIterator.hasNext()) {
                    site_loisir key = avsiteIterator.next();
                    int nbAvisSite = avsite.get(key).size();
                    totalAvis += nbAvisSite;
                    totalAvisSite += nbAvisSite;

                    // Afficher le nom du site de loisir et le nombre d'avis associé
                    System.out.println("Site de Loisir : " ); key.afficher(); System.out.println( ", Nombre d'avis : " + nbAvisSite);
                }

                // Affichage du nombre total d'avis postés
                System.out.println("Nombre total d'avis : " + totalAvis);

                // Nombre d'avis par catégorie d'objets (PRODUIT / SITE DE LOISIR)
                System.out.println("Nombre total d'avis pour les produits : " + totalAvisProduit);
                System.out.println("Nombre total d'avis pour les sites de loisir : " + totalAvisSite);

                // Nombre et liste des visiteurs différents utilisant le site
                


	        // Print the number of users (number of visitors)
	        int nombreUtilisateurs = util.size();
	        System.out.println("Nombre total d'utilisateurs : " + nombreUtilisateurs);
	        for (int i=0;i<util.size();i++)
	        {
	        	visiteurs v=util.get(i);
	        	v.afficher();
	        }
	        // afficher le nbre d'admin
	        int nombreadmin = administrateur.size();
	        System.out.println("Nombre total d'administrateurs: " + nombreadmin);
	        for (int i=0;i<administrateur.size();i++)
	        {
	        	admin a=administrateur.get(i);
	        	System.out.println(a.getNom());
	        }
	    }// on affiche seulement le nom pour l'admin car ce sont des données privées 
           
            
            public void ajout_vis(visiteurs v) {
                v.saisir();
                if (util.contains(v)) {
                    System.out.println("visiteur existant !!");
                } else {
                    util.add(v);
                }
            }
  
            public void ajout_adm(admin a) {
                a.saisir();
                if (administrateur.contains(a)) {
                    System.out.println("administrateur existant !!");
                } else {
                    administrateur.add(a);
                }
            }
    
	public HashMap<produit, ArrayList<avis>> getAvprod() {
		return avprod;
	}
	public void setAvprod(HashMap<produit, ArrayList<avis>> avprod) {
		this.avprod = avprod;
	}
	public HashMap<site_loisir, ArrayList<avis>> getAvsite() {
		return avsite;
	}
	public void setAvsite(HashMap<site_loisir, ArrayList<avis>> avsite) {
		this.avsite = avsite;
	}
	public ArrayList<visiteurs> getUtil() {
		return util;
	}
	public void setUtil(ArrayList<visiteurs> util) {
		this.util = util;
	}
	public ArrayList<admin> getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(ArrayList<admin> administrateur) {
		this.administrateur = administrateur;
	}
}

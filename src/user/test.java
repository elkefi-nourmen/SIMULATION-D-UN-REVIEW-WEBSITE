package user;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        // initialisation d'un review site
        HashMap<produit, ArrayList<avis>> avprod = new HashMap<>();
        HashMap<site_loisir, ArrayList<avis>> avsite = new HashMap<>();
        ArrayList<visiteurs> util = new ArrayList<>();
        ArrayList<admin> administrateur = new ArrayList<>();
        review_site rs = new review_site(avprod, avsite, util, administrateur);

        visiteurs v = new visiteurs("arij", "56625603", "arij086@gmail.com");
        visiteurs b = new visiteurs("maram", "25799406", "elkefimaram123@gmail.com");
        visiteurs c = new visiteurs("nessrine", "95644111", "benayed@gmail.com");
        admin k = new admin("nourmen", "94812987", "elkefinourmen123@gmail.com");
        rs.util.add(v);
        rs.util.add(b);
        rs.util.add(c);
        rs.administrateur.add(k);

        produit p = new produit("pc", "informatique", "lenovo");
        produit p2 = new produit("concealer", "beaute", "revolution");
        produit p3 = new produit("galaxyA50", "telephonie", "samsung");

        avis a = new avis("arij", p, 2, "un produit moyen");
        initializeReviews(rs.avprod, p);
        rs.getAvprod().get(p).add(a);

        a = new avis("arij", p2, 5, "excellent coverage");
        initializeReviews(rs.avprod, p2);
        rs.getAvprod().get(p2).add(a);

        a = new avis("nessrine", p2, 3, "medium");
        initializeReviews(rs.avprod, p2);
        rs.getAvprod().get(p2).add(a);

        site_loisir s1 = new site_loisir("sunnydays","ariana", "tunis", "restaurant");
        avis a2 = new avis("maram", s1, 4, "Super endroit pour des aventures");
        initializeReviews(rs.avsite, s1);
        rs.getAvsite().get(s1).add(a2);

        // menu
        char type,quitter;
        do {
            System.out.println("************************   Review Site   ************************");
            type = ' '; quitter = 'n';
            while (Character.toLowerCase(type) != 'a' && Character.toLowerCase(type) != 'v') {
                System.out.println("Admin ou visiteurs ?? saisissez a si admin ou v pour visiteur");
                type = s.next().charAt(0);
            }

            if (Character.toLowerCase(type) == 'v') {
                System.out.println("******************************  WELCOME  ******************************");
                System.out.println("Inserez vos données");
                visiteurs v1 = new visiteurs();
                rs.ajout_vis(v1);

                char choice = 'o';
                avis a5 = new avis();
                do {
                    System.out.println("choisissez un numero de commande");
                    System.out.println("1 - Publier un commentaire");
                    System.out.println("2 - Consulter la totalité des avis publies par categorie d’objets");
                    System.out.println("3 - Rechercher un objet bien détermine et consulter les avis publies sur cet objet");

                    int u = s.nextInt();
                    switch (u) {
                    case 1:
                        v1.publier(a5,rs);
                        
                        break;

                    case 2:
                        rs.afficherTousLesAvisProduit();
                        rs.afficherTousLesAvisSite();
                        break;

                    case 3:
                    	char x='l';
                    	 while (Character.toLowerCase(x) != 'p' && Character.toLowerCase(x) != 's') {
                    	        System.out.println("Saisissez la catégorie de cet objet : P s'il est un produit et S s'il est un site de loisirs");
                    	        x = s.next().charAt(0);
                    	        
                    	    }  
                    	 if (Character.toLowerCase(x)=='p') {
                       produit prod = new produit();
                        prod.saisir();
                       rs.afficherAvisProduit(prod);}
                    	 else 
                    	 {
                    		 site_loisir site=new site_loisir();
                    		 site.saisir();
                    		 rs.afficherAvisSite(site);
                    	 }
                    	
                        break;
                }

                    System.out.println("voulez vous faire une autre commande ? tapez o pour oui ou n pour non ");
                    choice = s.next().charAt(0);
                } while (Character.toLowerCase(choice) == 'o');
            }else {
                System.out.println("******************************  WELCOME  ******************************");
                System.out.println("Inserez vos donnees");
                admin a1 = new admin();
                rs.ajout_adm(a1);

                char choice = 'o';
                avis a5 = new avis();
                do {
                    System.out.println("choisissez un numero de commande");
                    System.out.println("1 - Consulter la totalité des avis publies par categorie d objets");
                    System.out.println("2 - Supprimer un avis Indesirable  ");
                    System.out.println("3 - Afficher les statistiques de la site");

                    int u = s.nextInt();
                    switch (u) {
                    case 1:
                    	 rs.afficherTousLesAvisProduit();
                         rs.afficherTousLesAvisSite();
                        break;

                    case 2:
                    	System.out.println("ecrivez la mot indesirable pour supprimez chaque avis la contient");
                       String mot=s.next();
                       rs.supprimerAvisIndesirable(mot);
                        break;

                    case 3:
                      rs.statistics();
                        break;
                }

                    System.out.println("voulez vous faire une autre commande ? tapez o pour oui ou n pour non ");
                    choice = s.next().charAt(0);
                } while (Character.toLowerCase(choice) == 'o');
            
            	
            }

            if (Character.toLowerCase(type) != 'n') {
                System.out.println("voulez vous quitter ? tapez o pour oui ou n pour non ");
                quitter = s.next().charAt(0);
            }
        } while (Character.toLowerCase(quitter) != 'o');
    } // end main

    // initialiser les avis pour le avprod
    private static void initializeReviews(HashMap<produit, ArrayList<avis>> avprod, produit product) {
        if (!avprod.containsKey(product)) {
            avprod.put(product, new ArrayList<>());
        }
    }

    // initialiser les avis pour le avsite
    private static void initializeReviews(HashMap<site_loisir, ArrayList<avis>> avsite, site_loisir site) {
        if (!avsite.containsKey(site)) {
            avsite.put(site, new ArrayList<>());
        }
    }
}


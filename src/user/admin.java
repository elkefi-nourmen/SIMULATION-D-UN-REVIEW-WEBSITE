package user;

public class admin extends visiteurs {

	public admin(String nom, String tel, String mail) {
		super(nom, tel, mail);
		// TODO Auto-generated constructor stub
	}

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void publier(avis a, review_site rs) {
		System.out.println(" avez pas le droit de publier ");
	}

}

package util;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ressources {
	public static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("JAVAEE_PROJET"); 
	public static SessionUtilisateur session_util=new SessionUtilisateur();
	public static ArrayList<String> roles = new ArrayList<String>() {{
	    add("Investisseur");
	    add("Administrateur");
	    add("Entreprise");
	}};
	
	public static ArrayList<String> secteurs = new ArrayList<String>() {{
	    add("Banque et Finance");
	    add("Agriculture");
	    add("Telecommunication");
	}};
}

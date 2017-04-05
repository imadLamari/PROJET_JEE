package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import model.Utilisateur;
import util.Ressources;




@Stateless
public class UtilisateurDAO {

private EntityManager em;
 
  public UtilisateurDAO() {
	  em=Ressources.emf.createEntityManager(); 
  }

  
  public boolean create(Utilisateur o) {
	  em=Ressources.emf.createEntityManager();
	  em.getTransaction().begin();
	  em.persist(o);
	  em.getTransaction().commit();
	  em.close();
    return true;
  }

  

  public Utilisateur getByLogin(String login) {
	  em=Ressources.emf.createEntityManager();
	    Utilisateur o = (Utilisateur) em.
	    		createQuery("from Utilisateur where login = :slogin").
	    		setParameter("slogin", login).getResultList().get(0); 
	    em.close();
    
    return o;
  }

  public Utilisateur getById(int id) {
	  em=Ressources.emf.createEntityManager();
	Utilisateur user=em.find(model.Utilisateur.class, new Integer(id));
	em.close();
    return user;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Utilisateur> getAllInvest() {
	  em=Ressources.emf.createEntityManager(); 
    ArrayList<Utilisateur> o = (ArrayList<Utilisateur>) em.
    		createQuery("from Utilisateur where role = 'Investisseur'").
    		getResultList();
    em.close();
    return o;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Utilisateur> getAllCompanyMember() {

	  em=Ressources.emf.createEntityManager();
	  ArrayList<Utilisateur> o = (ArrayList<Utilisateur>) em.
	    		createQuery("from Utilisateur where role = 'Entreprise'").
	    		getResultList();
	  em.close();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Utilisateur> getAllAdmin() {
	  em=Ressources.emf.createEntityManager();
	  ArrayList<Utilisateur> o = (ArrayList<Utilisateur>) em.
	    		createQuery("from Utilisateur where role = 'Administrateur'").
	    		getResultList();
	  em.close();
	    return o;
  }

  public boolean update(Utilisateur utilisateur) { 

	em=Ressources.emf.createEntityManager();
	em.getTransaction().begin();
	em.merge(utilisateur);
	em.getTransaction().commit();
	em.close();
    return true;
  }

  @SuppressWarnings("unchecked")
  public List<Utilisateur> getAll() {
	  em=Ressources.emf.createEntityManager();
	  em.getTransaction().begin();
	  ArrayList<Utilisateur> o = (ArrayList<Utilisateur>) em.
	    		createQuery("from Utilisateur").
	    		getResultList();
	  em.getTransaction().commit();
	  em.close();
	    return o;  
  }

 
}

package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import model.Information;
import model.Utilisateur;
import util.Ressources;


@Stateless
public class InformationDAO {

	private EntityManager em;
	 
	  public InformationDAO() {
		  em=Ressources.emf.createEntityManager(); 
	  }

	  
	  public boolean create(Information o) {
		  em=Ressources.emf.createEntityManager();
		  em.getTransaction().begin();
		  em.persist(o);
		  em.getTransaction().commit();
		  em.close();
	    return true;
	  }
  
  public boolean delete(Information o) {
	  em =Ressources.emf.createEntityManager();
	  em.getTransaction().begin();	  
 	  em.remove(o);
 	  em.getTransaction().commit();
 	  
      return true;
  } 
  
  public boolean update(Information Information) {
	  em =Ressources.emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Information);
		em.getTransaction().commit();
		
	    return true;
   }
  
  public Information getById(int id) {
	  em =Ressources.emf.createEntityManager();
	  Information comp=em.find(model.Information.class, new Integer(id));
	    return comp;
  }


  @SuppressWarnings("unchecked")
  public ArrayList<Information> getAllInformationByType(String type) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Information> o = (ArrayList<Information>) em.
	    		createQuery("from Information where type = :stype").
	    		setParameter("stype", type).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Information> getAllInformationByUser(int user) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Information> o = (ArrayList<Information>) em.
	    		createQuery("from Information where utilisateur = :suser").
	    		setParameter("suser", user).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Information> getAllInformationByEntrprise(String entreprise) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Information> o = (ArrayList<Information>) em.
	    		createQuery("from Information where entreprise.nom = :sentreprise").
	    		setParameter("sentreprise", entreprise).
	    		getResultList();
	    return o;
  }

 
  @SuppressWarnings("unchecked")
  public List<Information> getAll() {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Information> o = (ArrayList<Information>) em.
	    		createQuery("from Information").
	    		getResultList();
	    return o;  
  }
}

package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import model.Entreprise;
import util.Ressources;


@Stateless
public class EntrepriseDAO {

  private EntityManager em ;
	
  public EntrepriseDAO() {
	  em=Ressources.emf.createEntityManager();
  }

  
  public boolean create(Entreprise o) {
	  em =Ressources.emf.createEntityManager(); 
	  em.getTransaction().begin();	  
 	  em.persist(o);
 	  em.getTransaction().commit();
 	  
    return true;
  }
  
  public boolean delete(Entreprise o) {
	  em =Ressources.emf.createEntityManager(); 
	  em.getTransaction().begin();	  
 	  em.remove(o);
 	  em.getTransaction().commit();
 	  
      return true;
  }  
  

  public Entreprise getByName(String name) {
	  em =Ressources.emf.createEntityManager(); 
	    Entreprise o = (Entreprise) em.
	    		createQuery("from Entreprise where nom = :sname").
	    		setParameter("sname", name).getResultList().get(0); 
	    em.close();
    
    return o;
  }

  public Entreprise getById(int id) {
	  em =Ressources.emf.createEntityManager(); 
	  Entreprise comp=em.find(model.Entreprise.class, new Integer(id));
	  em.close();
    return comp;
  }



  @SuppressWarnings("unchecked")
  public ArrayList<Entreprise> getAllEntrpriseInSector(String secteur) {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Entreprise> o = (ArrayList<Entreprise>) em.
	    		createQuery("from Entreprise where secteur = :ssecteur").
	    		setParameter("ssecteur", secteur).
	    		getResultList();
	  em.close();
	    return o;
  }

  public boolean update(Entreprise Entreprise) {
	  em =Ressources.emf.createEntityManager(); 
	em.getTransaction().begin();
	em.merge(Entreprise);
	em.getTransaction().commit();
	em.close();
	
    return true;
  }

  @SuppressWarnings("unchecked")
  public List<Entreprise> getAll() {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Entreprise> o = (ArrayList<Entreprise>) em.
	    		createQuery("from Entreprise").
	    		getResultList();
	  em.close();
	    return o;  
  }
}

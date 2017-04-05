package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import model.Offre;
import util.Ressources;


@Stateless
public class OffreDAO {

	public EntityManager em =Ressources.emf.createEntityManager(); 
  public OffreDAO() {
    super();
  }

  
  public boolean create(Offre o) {
	  em =Ressources.emf.createEntityManager(); 
	  em.getTransaction().begin();	  
 	  em.persist(o);
 	  em.getTransaction().commit();
 	  
    return true;
  }
  
  public boolean delete(Offre o) {
	  em =Ressources.emf.createEntityManager(); 
	  em.getTransaction().begin();	  
 	  em.remove(o);
 	  em.getTransaction().commit();
 	  
      return true;
  } 
  
  public boolean update(Offre Offre) {
	  em =Ressources.emf.createEntityManager(); 
	    
		em.getTransaction().begin();
		em.persist(Offre);
		em.getTransaction().commit();
		
	    return true;
   }
  
  public Offre getById(int id) {
	  em =Ressources.emf.createEntityManager(); 
		Offre comp=em.find(model.Offre.class, new Integer(id));
	    return comp;
  }


  @SuppressWarnings("unchecked")
  public ArrayList<Offre> getAllOffreByModeNegociation(String mode) {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Offre> o = (ArrayList<Offre>) em.
	    		createQuery("from Offre where mode_negociation = :smode").
	    		setParameter("smode", mode).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Offre> getAllOffreByEtat(String etat) {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Offre> o = (ArrayList<Offre>) em.
	    		createQuery("from Offre where type_offre = :setat").
	    		setParameter("setat", etat).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Offre> getAllOffreByRecepteur(String recepteur) {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Offre> o = (ArrayList<Offre>) em.
	    		createQuery("from Offre where recepteur = :srecepteur").
	    		setParameter("srecepteur", recepteur).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Offre> getAllOffreByContact(int contract) {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Offre> o = (ArrayList<Offre>) em.
	    		createQuery("from Offre where contract.id = :scontract").
	    		setParameter("scontract", contract).
	    		getResultList();
	    return o;
  }

 
  @SuppressWarnings("unchecked")
  public List<Offre> getAll() {
	  em =Ressources.emf.createEntityManager(); 
	  ArrayList<Offre> o = (ArrayList<Offre>) em.
	    		createQuery("from Offre").
	    		getResultList();
	    return o;  
  }
}

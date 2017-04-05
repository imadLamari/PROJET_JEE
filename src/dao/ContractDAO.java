package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import model.Contract;
import model.Utilisateur;
import util.Ressources;


@Stateless
public class ContractDAO {

	public EntityManager em =Ressources.emf.createEntityManager();
  public ContractDAO() {
    super();
  }

  
  public boolean create(Contract o) {
	  em =Ressources.emf.createEntityManager();
	  em.getTransaction().begin();	  
 	  em.persist(o);
 	  em.getTransaction().commit();
    return true;
  }
  
  public boolean delete(Contract o) {
	  em =Ressources.emf.createEntityManager();
	  em.getTransaction().begin();	  
 	  em.remove(o);
 	  em.getTransaction().commit();
      return true;
  }  
   
  public boolean update(Contract Contract) {
	  	em =Ressources.emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Contract);
		em.getTransaction().commit();
	    return true;
  }

  public Contract getById(int id) {
	  em =Ressources.emf.createEntityManager();
	  Contract comp=em.find(model.Contract.class, new Integer(id));
    return comp;
  }



  @SuppressWarnings("unchecked")
  public ArrayList<Contract> getAllTypeProduct(String typeProduct) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract where type_produit = :stype_produit").
	    		setParameter("stype_produit", typeProduct).
	    		getResultList();
	    return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Contract> getAllTypeEmission(String typeEmission) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract where type_emission = :stype_emission").
	    		setParameter("stype_emission", typeEmission).
	    		getResultList();
	    return o;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Contract> getAllTypeContract(String typeContract) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract where type_contarct = :stype_contarct").
	    		setParameter("stype_contarct", typeContract).
	    		getResultList();
	  return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Contract> getAllEmetteurContract(String emetteur) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract where emetteur.nom = :semetteur").
	    		setParameter("semetteur", emetteur).
	    		getResultList();
	  return o;
  }
  
  @SuppressWarnings("unchecked")
  public ArrayList<Contract> getAllEntrepriseContract(String entreprise) {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract where entreprise.nom = :sentreprise").
	    		setParameter("sentreprise", entreprise).
	    		getResultList();
	  return o;
  }

  @SuppressWarnings("unchecked")
  public List<Contract> getAll() {
	  em =Ressources.emf.createEntityManager();
	  ArrayList<Contract> o = (ArrayList<Contract>) em.
	    		createQuery("from Contract").
	    		getResultList();
	    return o;  
  }
}

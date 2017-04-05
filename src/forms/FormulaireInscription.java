package forms;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import dao.EntrepriseDAO;
import model.Utilisateur;
import util.SessionUtilisateur;



@Stateless
public class FormulaireInscription {

  @EJB
  private EntrepriseDAO entrepriseDao;
  @Inject
  private SessionUtilisateur session_util=new SessionUtilisateur();

  public Utilisateur getUser(HttpServletRequest request) {
    Utilisateur user = new Utilisateur();
    user.setPrenom(session_util.getInputValue(request, "prenom"));
    user.setNom(session_util.getInputValue(request, "nom"));
    user.setLogin(session_util.getInputValue(request, "login"));
    user.setPassword(session_util.getInputValue(request, "password"));
    user.setRole("Investisseur");
    user.setEntreprise(null);
    user.setValide((byte) 0);
    return user;
  }
}


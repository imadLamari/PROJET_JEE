package forms;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import dao.EntrepriseDAO;
import model.Entreprise;
import model.Utilisateur;
import util.SessionUtilisateur;



@Stateless
public class FormulaireEntreprise {

  @EJB
  private EntrepriseDAO entrepriseDao;
  @Inject
  private SessionUtilisateur session_util=new SessionUtilisateur();

  public Entreprise getEntreprise(HttpServletRequest request) {
	Entreprise entreprise = new Entreprise();
	entreprise.setNom(session_util.getInputValue(request, "nom"));
	entreprise.setEffectif(session_util.getInputValue(request, "effectif"));
	entreprise.setSiteWeb(session_util.getInputValue(request, "siteWeb"));
	entreprise.setChiffreAffaire(session_util.getInputValue(request, "chiffreAffaire"));
	entreprise.setSecteur(session_util.getInputValue(request, "secteurSelect"));
	entreprise.setValide((byte) 0);
    return entreprise;
  }
}


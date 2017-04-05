package util;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;
import model.Utilisateur;



@Stateless
public class SessionUtilisateur {
  @EJB
  private UtilisateurDAO ud;

  public static String getInputValue(HttpServletRequest request, String inputName) {
    String value = request.getParameter(inputName);
    if (value == null || value.trim().length() == 0) {
      return null;
    } else {
      return value.trim();
    }
  }

  public void login(Utilisateur u, HttpSession session) {
    session.setAttribute("utilisateur", u);
  }

  public void logout(HttpSession session) {
    session.invalidate();
  }

  public void updateUser(HttpSession session) {
    Utilisateur u = currentUser(session);
    u = ud.getById(u.getId());
    session.setAttribute("utilisateur", u);
  }

  public Utilisateur currentUser(HttpSession session) {
    return (Utilisateur) session.getAttribute("utilisateur");
  }
  
}


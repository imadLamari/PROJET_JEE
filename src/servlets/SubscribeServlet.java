package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDAO;
import forms.FormulaireInscription;
import model.Utilisateur;
import util.SessionUtilisateur;

@WebServlet("/signup")
public class SubscribeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private FormulaireInscription inscriptionForm;
  @EJB
  private UtilisateurDAO uda=new UtilisateurDAO();
  @Inject
  private SessionUtilisateur session_util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	  session_util=new SessionUtilisateur();
	  
      uda=new UtilisateurDAO();
      Utilisateur u=uda.getByLogin(session_util.getInputValue(request, "login"));
      if(u!=null){
    	  if(u.getPassword().equals(session_util.getInputValue(request, "password"))){
    		  session_util.login(u, request.getSession());
    	  }
    	  this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
    	  
      } else{
    	  this.getServletContext().getRequestDispatcher("/WEB-INF/inscription/login.jsp").forward(request, response);
      }
   }
    

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Utilisateur u = inscriptionForm.getUser(request);

    if (uda.create(u)) {
    	session_util.login(u, request.getSession());
        request.getSession().setAttribute("subscribe", "Inscription réussie.");
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription/login.jsp").forward(request, response);

      } else {
       request.setAttribute("error", "Votre login et/ou votre email n'est pas disponible.");
       this.getServletContext().getRequestDispatcher("/WEB-INF/inscription/login.jsp").forward(request, response);
    }
  }
}

package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import forms.FormulaireEntreprise;
import forms.FormulaireInscription;
import model.Entreprise;
import model.Utilisateur;
import util.SessionUtilisateur;

/**
 * Servlet implementation class EntrepriseNouveauServlet
 */
@WebServlet("/EntrepriseNouveauServlet")
public class EntrepriseNouveauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	  @EJB
	  private FormulaireEntreprise inscriptionForm;
	  @EJB
	  private EntrepriseDAO eda=new EntrepriseDAO();
	  @Inject
	  private SessionUtilisateur session_util;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseNouveauServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Entreprise e = inscriptionForm.getEntreprise(request);
        UtilisateurDAO uda=new UtilisateurDAO();
        Utilisateur u=session_util.currentUser(request.getSession());
        
        if(request.getParameter("type").equals("add")){
        	if (eda.create(e)) {
    	    	
    	    	Entreprise en=eda.getByName(e.getNom());
    	    	u.setEntreprise(en);
    	    	uda.update(u);
    	    	session_util.login(u, request.getSession());

    	     }
        }else{
        	e.setId(u.getEntreprise().getId());
        	e.setValide(u.getEntreprise().getValide());
        	eda.update(e);
        	u.setEntreprise(e);
        	uda.update(u);
        }
          this.getServletContext().getRequestDispatcher("/WEB-INF/espace/acceuil-entreprise.jsp").forward(request, response);
	}
}


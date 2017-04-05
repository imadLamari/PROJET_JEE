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
import dao.InformationDAO;
import dao.UtilisateurDAO;
import forms.FormulaireEntreprise;
import forms.FormulaireInscription;
import model.Entreprise;
import model.Information;
import model.Utilisateur;
import util.SessionUtilisateur;

/**
 * Servlet implementation class EntrepriseNouveauServlet
 */
@WebServlet("/InformationNouveau")
public class InformationNouveau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	  
	  @EJB
	  private InformationDAO ida=new InformationDAO();
	  @Inject
	  private SessionUtilisateur session_util;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationNouveau() {
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
		Information i=new Information();
		
		UtilisateurDAO uda=new UtilisateurDAO();
        Utilisateur u=session_util.currentUser(request.getSession());
		
		i.setType(request.getParameter("type"));
		i.setDescriptif(request.getParameter("descriptif"));
		i.setUtilisateur(u.getId());
		i.setEntreprise(u.getEntreprise().getId());
		
        ida.create(i);
         
        this.getServletContext().getRequestDispatcher("/EntrepriseInformation").forward(request, response);
	}
}


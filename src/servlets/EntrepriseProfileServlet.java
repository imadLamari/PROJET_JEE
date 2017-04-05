package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntrepriseDAO;
import model.Utilisateur;
import util.Ressources;
import util.SessionUtilisateur;

/**
 * Servlet implementation class EntrepriseProfileServlet
 */
@WebServlet("/EntrepriseProfileServlet")
public class EntrepriseProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private EntrepriseDAO ud;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      SessionUtilisateur su=new SessionUtilisateur();
      Utilisateur user =su.currentUser(request.getSession());
      request.setAttribute("entreprise", user.getEntreprise());
      request.setAttribute("secteurs", Ressources.secteurs);
      this.getServletContext().getRequestDispatcher("/WEB-INF/espace/Entreprise/EntrepriseProfil.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

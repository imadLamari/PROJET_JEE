package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import model.Entreprise;
import model.Utilisateur;
import util.Ressources;

/**
 * Servlet implementation class AllEntrepriseServlet
 */
@WebServlet("/AllEntrepriseServlet")
public class AllEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private EntrepriseDAO ud;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<Entreprise> listeEntreprises = (ArrayList<Entreprise>) ud.getAll();
      request.setAttribute("listeEntreprise", listeEntreprises);
        this.getServletContext().getRequestDispatcher("/WEB-INF/espace/Entreprise/AllEntreprise.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDAO;
import model.Utilisateur;
import util.Ressources;

/**
 * Servlet implementation class AllInvestisseurServlet
 */
@WebServlet("/AllInvestisseurServlet")
public class AllInvestisseurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllInvestisseurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private UtilisateurDAO ud;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<Utilisateur> listeUsers = (ArrayList<Utilisateur>) ud.getAll();
      request.setAttribute("listeUsers", listeUsers);
      request.setAttribute("Roles", Ressources.roles);
        this.getServletContext().getRequestDispatcher("/WEB-INF/espace/Utilisateur/AllUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

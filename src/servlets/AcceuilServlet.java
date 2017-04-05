package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDAO;
import model.Utilisateur;
import util.SessionUtilisateur;

/**
 * Servlet implementation class serv
 */
@WebServlet("/accueil")
public class AcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceuilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Inject
    private SessionUtilisateur su;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (su.currentUser(request.getSession()) == null) {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription/login.jsp").forward(request, response);
      } else if (su.currentUser(request.getSession()).getRole().equals("Administrateur")) {
        this.getServletContext().getRequestDispatcher("/WEB-INF/espace/acceuil-admin.jsp").forward(request, response);
      } else if (su.currentUser(request.getSession()).getRole().equals("Entreprise")) {
        this.getServletContext().getRequestDispatcher("/WEB-INF/espace/acceuil-entreprise.jsp").forward(request, response);
      } else {
        this.getServletContext().getRequestDispatcher("/WEB-INF/espace/acceuil-investisseur.jsp").forward(request, response);
      }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

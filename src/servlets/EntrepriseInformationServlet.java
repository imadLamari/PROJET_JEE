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
import dao.InformationDAO;
import model.Entreprise;
import model.Information;
import model.Utilisateur;
import util.SessionUtilisateur;

/**
 * Servlet implementation class EntrepriseInformationServlet
 */
@WebServlet("/EntrepriseInformationServlet")
public class EntrepriseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @EJB
    private EntrepriseDAO ud;
    
    @EJB
    private InformationDAO id;
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      SessionUtilisateur su=new SessionUtilisateur();
      Utilisateur user =su.currentUser(request.getSession());
      
      ArrayList<Information> infos=id.getAllInformationByUser(user.getId());
      
      request.setAttribute("infos", infos);
      this.getServletContext().getRequestDispatcher("/WEB-INF/espace/Entreprise/EntrepriseInformation.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

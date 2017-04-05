package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContractDAO;
import dao.EntrepriseDAO;
import model.Contract;
import model.Entreprise;
import model.Utilisateur;
import util.Ressources;
import util.SessionUtilisateur;

/**
 * Servlet implementation class EntrepriseContract
 */
@WebServlet("/EntrepriseContract")
public class EntrepriseContract extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseContract() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private EntrepriseDAO ud;
    
    @EJB
    private ContractDAO cd;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      SessionUtilisateur su=new SessionUtilisateur();
      Utilisateur user =su.currentUser(request.getSession());
      
      ArrayList<Contract> contracts = (ArrayList<Contract>) cd.getAll();
      request.setAttribute("contracts", contracts);
      
      this.getServletContext().getRequestDispatcher("/WEB-INF/espace/Entreprise/EntrepriseContracts.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

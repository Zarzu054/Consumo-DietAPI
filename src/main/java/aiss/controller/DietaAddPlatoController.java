package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.DietaResource;

/**
 * Servlet implementation class DietaAddPlatoController
 */
public class DietaAddPlatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DietaAddPlatoController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DietaAddPlatoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String PlatoId = request.getParameter("PlatoId");
		String DietaId = request.getParameter("DietaId");
				
		// Add Plato to Dieta
		DietaResource plr = new DietaResource();
		boolean success = plr.addPlato(DietaId, PlatoId);
		
		if (success) {
			request.setAttribute("message", "Plato added successfully");
			log.log(Level.FINE, "Plato with id=" + PlatoId + " added to Dieta with id=" + DietaId + ". Forwarding to Dieta list view.");
		}
		else {
			request.setAttribute("message", "The Plato could not be added");
			log.log(Level.FINE, "The Plato with id=" + PlatoId + " could not be added to the Dieta with id=" + DietaId + ". Perhaps it is duplicated. Forwarding to Dieta list view.");
		}
		
		// Forward to contact list view
		request.getRequestDispatcher("/list?DietaId=" + DietaId).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

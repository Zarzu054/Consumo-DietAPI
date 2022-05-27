package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Dieta;
import aiss.model.resources.DietaResource;

/**
 * Servlet implementation class ContactDeleteController
 */
public class PlatoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(PlatoUpdateController.class.getName());
	
    public PlatoDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Request data
		String PlatoId = request.getParameter("PlatoId");
		String DietaId = request.getParameter("DietaId");
		
		// Validate data
		if (PlatoId==null) {
			log.log(Level.SEVERE, "Error deleting Plato. Null id ");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		// Log
		log.log(Level.FINE, "Deleting Plato with id " + PlatoId);
		
		// Delete Plato
		DietaResource plr = new DietaResource();
		plr.removePlato(DietaId, PlatoId);
		
		// Forward to contact list view
		request.setAttribute("message", "Plato deleted successfully");
		request.getRequestDispatcher("/list").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

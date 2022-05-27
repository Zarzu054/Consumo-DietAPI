package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Dieta;
import aiss.model.Plato;
import aiss.model.resources.PlatoResource;


/**
 * Servlet implementation class DeleteContactController
 */
public class PlatoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PlatoUpdateController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlatoUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String PlatoId = request.getParameter("PlatoId");
		String DietaId = request.getParameter("DietaId");
		String operation = request.getParameter("operation");
		
		// Plato resource
		PlatoResource sr = new PlatoResource();

		// Load Plato being updated
		Plato Plato = sr.getPlato(PlatoId);

		// Display update form with Plato data on it
		if (operation == null) {

			// Log
			log.log(Level.FINE, "Update request for contact with id " + PlatoId + " (name=" + Plato.getTitle() + "). Forwarding to edit view.");

			// Forward to edit view
			RequestDispatcher rd = request.getRequestDispatcher("/PlatoEditView.jsp?DietaId=" + DietaId);
			request.setAttribute("Plato", Plato);
			rd.forward(request, response);

		} else {			
			
			// Update Plato
			String artist = request.getParameter("artist");
			String title = request.getParameter("title");
			String album = request.getParameter("album");
			String year = request.getParameter("year");
			
			Plato.setArtist(artist);
			Plato.setTitle(title);
			Plato.setAlbum(album);
			Plato.setYear(year);
			
			sr.updatePlato(Plato);
			
			// Log
			log.log(Level.FINE, "Update request. Artist=" + Plato.getArtist() + ", Title= " + Plato.getTitle() + ", Album= " + Plato.getAlbum() + ", Year= " + Plato.getYear() + ". Forwarding to contact list view.");

			// Forward to Plato list view
			request.setAttribute("message", "Plato updated successfully");
			request.getRequestDispatcher("/list").forward(request, response);
				
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

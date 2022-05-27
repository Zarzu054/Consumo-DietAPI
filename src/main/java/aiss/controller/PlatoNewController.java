package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Plato;
import aiss.model.resources.DietaResource;
import aiss.model.resources.PlatoResource;


/**
 * Servlet implementation class ContactNewController
 */
public class PlatoNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(PlatoUpdateController.class.getName());
	
    public PlatoNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String artist = request.getParameter("artist");
		String title = request.getParameter("title");
		String album = request.getParameter("album");
		String year = request.getParameter("year");
		String DietaId = request.getParameter("DietaId");
		
		// Create Plato
		PlatoResource sr = new PlatoResource();
		Plato Plato = sr.addPlato(new Plato(title, artist, album, year));
		
		// Add Plato to the Dieta
		DietaResource plr = new DietaResource();
		plr.addPlato(DietaId, Plato.getId());

		// Log
		log.log(Level.FINE, "New Plato request. artist=" + artist + ", title= " + title + ", album= " + album + ", year= " + year +". Forwarding to Dieta list view.");

		// Forward to contact list view
		request.setAttribute("message", "Plato created successfully");
		request.setAttribute("DietaId", DietaId);
		request.getRequestDispatcher("/list").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

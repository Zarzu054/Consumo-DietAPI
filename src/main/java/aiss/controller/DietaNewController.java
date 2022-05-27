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
 * Servlet implementation class DietaNewController
 */
public class DietaNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DietaNewController.class.getName());
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String name = request.getParameter("name");

		// Add Dieta
		DietaResource plr = new DietaResource();
		Dieta Dieta = plr.addDieta(new Dieta());

		// Log
		log.log(Level.FINE, "New Dieta request. name=" + name + ". Forwarding to Dieta list view.");

		// Forward to contact list view
		request.setAttribute("message", "Dieta created successfully");
		request.getRequestDispatcher("/list?DietaId=" + Dieta.getId()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

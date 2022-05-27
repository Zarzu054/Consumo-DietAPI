package aiss.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Dieta;
import aiss.model.Plato;
import aiss.model.resources.DietaResource;
import aiss.model.resources.PlatoResource;

public class DietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(DietaController.class.getName());
	
    public DietaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Load all Dieta
		PlatoResource sr = new PlatoResource();
		Collection<Plato> Platos = sr.getAll();
		
		
		// Load all Dietas
		DietaResource plr = new DietaResource();
		Collection<Dieta> Dietas = plr.getAll();
			
		// Get selected Dieta
		String id = request.getParameter("DietaId");
		log.log(Level.FINE, "Id=" + id);
		
		Dieta Dieta=null;
		if (id!=null)	// Load the Dieta with the id received as a parameter
			Dieta = plr.getDieta(id);
		else if (id==null && !Dietas.isEmpty())	{// No Dieta selected, show the first one
			Dieta = (Dieta) Dietas.toArray()[0];
			id=Dieta.getId();
		}
		
		if (Dieta==null) {
			request.setAttribute("message", "Dieta not found");
			log.log(Level.FINE, "Dieta not found.");	
		} else
			log.log(Level.FINE, "Dieta with id " + id + " loaded.");
		
		// Forward to Dieta view
		request.setAttribute("Platos", Platos);
		request.setAttribute("plPlatos", Dieta.getPlatos());
		request.setAttribute("Dietas", Dietas);
		request.setAttribute("DietaId", id);	// id of the selected Dieta
		request.getRequestDispatcher("/DietaView.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

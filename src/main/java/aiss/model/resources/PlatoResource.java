package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Plato;

public class PlatoResource {

	private String uri = "http://playlist-api.appspot.com/api/Platos";
	//private String uri = "http://localhost:8095/api/Platos";

	
	public Collection<Plato> getAll() {
		ClientResource cr = null;
		Plato [] Platos = null;
		try {
			cr = new ClientResource(uri);
			Platos = cr.get(Plato[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all Platos: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(Platos);
	}
	

	public Plato getPlato(String PlatoId) {
		//TODO
		return null;
	}
	

	public Plato addPlato(Plato Plato) {
		// TODO
		return null;

	}
	
	public boolean updatePlato(Plato Plato) {
		// TODO
		return false;
	}
	

	public boolean deletePlato(String PlatoId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + PlatoId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Plato: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}

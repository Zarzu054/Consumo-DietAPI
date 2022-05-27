package aiss.model.resources;

import java.util.Arrays; 
import java.util.Collection;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Dieta;

public class DietaResource {

	private String uri = "http://Dieta-api.appspot.com/api/lists";
	//private String uri = "http://localhost:8095/api/lists";
	

	public Collection<Dieta> getAll() {
		
		ClientResource cr = null;
		Dieta[] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Dieta[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of Dietas: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	
	public Dieta getDieta(String DietaId) {
		
		ClientResource cr = null;
		Dieta list = null;
		try {
			cr = new ClientResource(uri + "/" + DietaId);
			list = cr.get(Dieta.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the Dieta: " + cr.getResponse().getStatus());
		}
		
		return list;

	}
	

	public Dieta addDieta(Dieta pl) {
		
		ClientResource cr = null;
		Dieta resultDieta = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultDieta = cr.post(pl,Dieta.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the Dieta: " + cr.getResponse().getStatus());
		}
		
		return resultDieta;
	}
	

	public boolean updateDieta(Dieta pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the Dieta: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	public boolean deleteDieta(String DietaId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + DietaId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Dieta: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addPlato(String DietaId, String PlatoId) {
		// TODO
		// Use	cr.post(" ") to avoid RESTlet crashing
		return false;
		
	}
	
	public boolean removePlato(String DietaId, String PlatoId) {
		// TODO
		return false;
	}
}

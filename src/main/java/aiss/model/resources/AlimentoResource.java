package aiss.model.resources;

import java.util.Arrays; 
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Alimento;

public class AlimentoResource {

	private String uri = "https://aiss-343810.ew.r.appspot.com/api/v1/alimentos";
	

	public Collection<Alimento> getAllAlimentos() {
		
		ClientResource cr = null;
		Alimento[] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Alimento[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of alimentos: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	
	public Alimento getAlimento(String alimentoId) {
		
		ClientResource cr = null;
		Alimento alimento = null;
		try {
			cr = new ClientResource(uri + "/" + alimentoId);
			alimento = cr.get(Alimento.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the alimento: " + cr.getResponse().getStatus());
		}
		
		return alimento;

	}
	

	public Alimento addAlimento(Alimento alimento) {
		
		ClientResource cr = null;
		Alimento resultAlimento = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultAlimento = cr.post(alimento, Alimento.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the alimento: " + cr.getResponse().getStatus());
		}
		
		return resultAlimento;
	}

	public boolean deleteAlimento(String alimentoId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + alimentoId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the alimento: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
}

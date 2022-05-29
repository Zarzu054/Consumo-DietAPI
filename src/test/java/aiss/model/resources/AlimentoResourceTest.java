package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.Alimento;

public class AlimentoResourceTest {
	
	private static AlimentoResource alimentoResource = new AlimentoResource();
	private static Alimento dorada;
	
	@BeforeClass
	public static void setUp() throws Exception {
		dorada = new Alimento();
		dorada.setNombre("Dorada");
		dorada.setCalorias(200);
		dorada.setCategoria("PESCADO");
		dorada.setTipo("PROTEINAS");
		dorada.setAlergeno("PESCADO");
		dorada.setTemporada("NOVIEMBRE");
		
		dorada = alimentoResource.addAlimento(dorada);
	}
	

	@Test
	public void SholudGetAllAlimentos() {
		Collection<Alimento> alimentosResult = 
				alimentoResource.getAllAlimentos().stream().limit(5).collect(Collectors.toList());
		Integer expectedSize = 5;
		assertNotNull("Alimentos resulted null", alimentosResult);
		assertFalse("The number of alimentos is zero", alimentosResult.size() == 0);
		assertTrue("Size does not match", alimentosResult.size() == expectedSize);
		
		for (Alimento alimento : alimentosResult) {
			System.out.println("Alimento: " + alimento.getNombre() + " AlimentoId=" + alimento.getId());
		}
	}
	
	@Test
	public void SholudGetAnAlimento(){
		String alimentoString = "";
		String alimentoId = "286al";
		Alimento alimentoResult = alimentoResource.getAlimento(alimentoId);
		
		assertNotNull("The alimento with id="+ alimentoId + " resulted null.", alimentoResult);
		assertEquals("The alimentoId and the one return by the API does not macth", alimentoId, alimentoResult.getId());
		alimentoString += String.format("Alimento: %s\n", alimentoResult.getNombre());
		alimentoString += String.format("Calorias: %s\n", alimentoResult.getCalorias());
		alimentoString += String.format("Tipo: %s\n", alimentoResult.getTipo());
		alimentoString += String.format("Temporada: %s\n", alimentoResult.getTemporada());
		alimentoString += String.format("Alérgeno: %s\n", alimentoResult.getAlergeno());
		alimentoString += String.format("Categoria: %s\n", alimentoResult.getCategoria());
		System.out.println(alimentoString);

	}
	
	@Test
	public void SholudAddAlimento(){
		String alimentoString = "";
		
		Alimento aceite = new Alimento();
		aceite.setNombre("Aceite de Oliva");
		aceite.setCalorias(400);
		aceite.setCategoria("FRUTAS");
		aceite.setTipo("LIPIDOS");
		aceite.setAlergeno("CEREALES");
		
		Alimento alimentoResult = alimentoResource.addAlimento(aceite);
		
		assertNotNull("There was an error while adding the alimento", alimentoResult);
		assertEquals("The alimento name and the one return by the API does not macth",
				aceite.getNombre(), aceite.getNombre());
		assertEquals("The calororias and the one return by the API does not match",
				aceite.getCalorias(), alimentoResult.getCalorias());
		
		alimentoString += String.format("Alimento: %s\n", alimentoResult.getNombre());
		alimentoString += String.format("Calorias: %s\n", alimentoResult.getCalorias());
		alimentoString += String.format("Tipo: %s\n", alimentoResult.getTipo());
		alimentoString += String.format("Temporada: %s\n", alimentoResult.getTemporada());
		alimentoString += String.format("Alérgeno: %s\n", alimentoResult.getAlergeno());
		alimentoString += String.format("Categoria: %s\n", alimentoResult.getCategoria());
		System.out.println(alimentoString);

	}
	
	@Test
	public void ShouldDeleteAlimento() {
		
		boolean success = alimentoResource.deleteAlimento(dorada.getId());
		Alimento alimentoResult = alimentoResource.getAlimento(dorada.getId());
		assertTrue("There was an error when deleting the alimento", success);
		assertNull("The alimento still persits", alimentoResult);
	}
}

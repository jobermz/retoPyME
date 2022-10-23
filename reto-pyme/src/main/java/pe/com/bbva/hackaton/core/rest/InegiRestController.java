package pe.com.bbva.hackaton.core.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.bbva.hackaton.core.model.entity.Inegi;
import pe.com.bbva.hackaton.core.service.InegiService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Inegi
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class InegiRestController {
	
	@Autowired
	private InegiService inegiService;
	
	@RequestMapping(value = "/inegi/", method = RequestMethod.GET)
	public ResponseEntity<List<Inegi>> listAllInegis() throws Exception {
		List<Inegi> inegis = inegiService.buscar(new Inegi(), null);
		if (inegis.isEmpty()) {
			return new ResponseEntity<List<Inegi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Inegi>>(inegis, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/inegi/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inegi> getInegi(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Inegi with id " + id);
		Inegi inegi = inegiService.buscarById(new Inegi(id));
		if (inegi == null) {
			System.out.println("Inegi with id " + id + " not found");
			return new ResponseEntity<Inegi>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inegi>(inegi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/inegi/", method = RequestMethod.POST)
	public ResponseEntity<Void> createInegi(@RequestBody Inegi inegi, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Inegi " + inegi.getStrNombre());
		if (inegiService.buscarById(inegi) != null) {
			//System.out.println("A Inegi with name " + inegi.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		inegiService.guardar(inegi);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/inegi/{id}").buildAndExpand(inegi.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/inegi/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Inegi> updateInegi(@PathVariable("id") Integer id, @RequestBody Inegi inegi) throws Exception {
		System.out.println("Updating Inegi " + id);

		Inegi currentInegi = inegiService.buscarById(new Inegi(id));

		if (currentInegi == null) {
			System.out.println("Inegi with id " + id + " not found");
			return new ResponseEntity<Inegi>(HttpStatus.NOT_FOUND);
		}

		inegiService.guardar(inegi);
		return new ResponseEntity<Inegi>(currentInegi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/inegi/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Inegi> deleteInegi(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Inegi with id " + id);

		Inegi inegi = inegiService.buscarById(new Inegi(id));
		if (inegi == null) {
			System.out.println("Unable to delete. Inegi with id " + id + " not found");
			return new ResponseEntity<Inegi>(HttpStatus.NOT_FOUND);
		}

		inegiService.eliminar(new Inegi(id));
		return new ResponseEntity<Inegi>(HttpStatus.NO_CONTENT);
	}
	
}
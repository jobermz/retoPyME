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

import pe.com.bbva.hackaton.core.model.entity.EmpresaBing;
import pe.com.bbva.hackaton.core.service.EmpresaBingService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Empresa Bing
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class EmpresaBingRestController {
	
	@Autowired
	private EmpresaBingService empresaBingService;
	
	@RequestMapping(value = "/empresaBing/", method = RequestMethod.GET)
	public ResponseEntity<List<EmpresaBing>> listAllEmpresaBings() throws Exception {
		List<EmpresaBing> empresaBings = empresaBingService.buscar(new EmpresaBing(), null);
		if (empresaBings.isEmpty()) {
			return new ResponseEntity<List<EmpresaBing>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpresaBing>>(empresaBings, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBing/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaBing> getEmpresaBing(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching EmpresaBing with id " + id);
		EmpresaBing empresaBing = empresaBingService.buscarById(new EmpresaBing(id));
		if (empresaBing == null) {
			System.out.println("EmpresaBing with id " + id + " not found");
			return new ResponseEntity<EmpresaBing>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmpresaBing>(empresaBing, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBing/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmpresaBing(@RequestBody EmpresaBing empresaBing, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating EmpresaBing " + empresaBing.getStrNombre());
		if (empresaBingService.buscarById(empresaBing) != null) {
			//System.out.println("A EmpresaBing with name " + empresaBing.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		empresaBingService.guardar(empresaBing);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/empresaBing/{id}").buildAndExpand(empresaBing.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/empresaBing/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmpresaBing> updateEmpresaBing(@PathVariable("id") Integer id, @RequestBody EmpresaBing empresaBing) throws Exception {
		System.out.println("Updating EmpresaBing " + id);

		EmpresaBing currentEmpresaBing = empresaBingService.buscarById(new EmpresaBing(id));

		if (currentEmpresaBing == null) {
			System.out.println("EmpresaBing with id " + id + " not found");
			return new ResponseEntity<EmpresaBing>(HttpStatus.NOT_FOUND);
		}

		empresaBingService.guardar(empresaBing);
		return new ResponseEntity<EmpresaBing>(currentEmpresaBing, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBing/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpresaBing> deleteEmpresaBing(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting EmpresaBing with id " + id);

		EmpresaBing empresaBing = empresaBingService.buscarById(new EmpresaBing(id));
		if (empresaBing == null) {
			System.out.println("Unable to delete. EmpresaBing with id " + id + " not found");
			return new ResponseEntity<EmpresaBing>(HttpStatus.NOT_FOUND);
		}

		empresaBingService.eliminar(new EmpresaBing(id));
		return new ResponseEntity<EmpresaBing>(HttpStatus.NO_CONTENT);
	}
	
}
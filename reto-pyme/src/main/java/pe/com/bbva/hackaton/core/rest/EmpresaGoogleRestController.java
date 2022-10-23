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

import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
import pe.com.bbva.hackaton.core.service.EmpresaGoogleService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Empresa Google
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class EmpresaGoogleRestController {
	
	@Autowired
	private EmpresaGoogleService empresaGoogleService;
	
	@RequestMapping(value = "/empresaGoogle/", method = RequestMethod.GET)
	public ResponseEntity<List<EmpresaGoogle>> listAllEmpresaGoogles() throws Exception {
		List<EmpresaGoogle> empresaGoogles = empresaGoogleService.buscar(new EmpresaGoogle(), null);
		if (empresaGoogles.isEmpty()) {
			return new ResponseEntity<List<EmpresaGoogle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpresaGoogle>>(empresaGoogles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGoogle> getEmpresaGoogle(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching EmpresaGoogle with id " + id);
		EmpresaGoogle empresaGoogle = empresaGoogleService.buscarById(new EmpresaGoogle(id));
		if (empresaGoogle == null) {
			System.out.println("EmpresaGoogle with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogle>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmpresaGoogle>(empresaGoogle, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogle/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmpresaGoogle(@RequestBody EmpresaGoogle empresaGoogle, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating EmpresaGoogle " + empresaGoogle.getStrNombre());
		if (empresaGoogleService.buscarById(empresaGoogle) != null) {
			//System.out.println("A EmpresaGoogle with name " + empresaGoogle.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		empresaGoogleService.guardar(empresaGoogle);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/empresaGoogle/{id}").buildAndExpand(empresaGoogle.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/empresaGoogle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmpresaGoogle> updateEmpresaGoogle(@PathVariable("id") Integer id, @RequestBody EmpresaGoogle empresaGoogle) throws Exception {
		System.out.println("Updating EmpresaGoogle " + id);

		EmpresaGoogle currentEmpresaGoogle = empresaGoogleService.buscarById(new EmpresaGoogle(id));

		if (currentEmpresaGoogle == null) {
			System.out.println("EmpresaGoogle with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogle>(HttpStatus.NOT_FOUND);
		}

		empresaGoogleService.guardar(empresaGoogle);
		return new ResponseEntity<EmpresaGoogle>(currentEmpresaGoogle, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpresaGoogle> deleteEmpresaGoogle(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting EmpresaGoogle with id " + id);

		EmpresaGoogle empresaGoogle = empresaGoogleService.buscarById(new EmpresaGoogle(id));
		if (empresaGoogle == null) {
			System.out.println("Unable to delete. EmpresaGoogle with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogle>(HttpStatus.NOT_FOUND);
		}

		empresaGoogleService.eliminar(new EmpresaGoogle(id));
		return new ResponseEntity<EmpresaGoogle>(HttpStatus.NO_CONTENT);
	}
	
}
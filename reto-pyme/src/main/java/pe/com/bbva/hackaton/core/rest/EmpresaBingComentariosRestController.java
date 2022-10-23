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

import pe.com.bbva.hackaton.core.model.entity.EmpresaBingComentarios;
import pe.com.bbva.hackaton.core.service.EmpresaBingComentariosService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Empresa Bing Comentarios
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class EmpresaBingComentariosRestController {
	
	@Autowired
	private EmpresaBingComentariosService empresaBingComentariosService;
	
	@RequestMapping(value = "/empresaBingComentarios/", method = RequestMethod.GET)
	public ResponseEntity<List<EmpresaBingComentarios>> listAllEmpresaBingComentarioss() throws Exception {
		List<EmpresaBingComentarios> empresaBingComentarioss = empresaBingComentariosService.buscar(new EmpresaBingComentarios(), null);
		if (empresaBingComentarioss.isEmpty()) {
			return new ResponseEntity<List<EmpresaBingComentarios>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpresaBingComentarios>>(empresaBingComentarioss, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBingComentarios/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaBingComentarios> getEmpresaBingComentarios(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching EmpresaBingComentarios with id " + id);
		EmpresaBingComentarios empresaBingComentarios = empresaBingComentariosService.buscarById(new EmpresaBingComentarios(id));
		if (empresaBingComentarios == null) {
			System.out.println("EmpresaBingComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaBingComentarios>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmpresaBingComentarios>(empresaBingComentarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBingComentarios/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmpresaBingComentarios(@RequestBody EmpresaBingComentarios empresaBingComentarios, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating EmpresaBingComentarios " + empresaBingComentarios.getStrNombre());
		if (empresaBingComentariosService.buscarById(empresaBingComentarios) != null) {
			//System.out.println("A EmpresaBingComentarios with name " + empresaBingComentarios.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		empresaBingComentariosService.guardar(empresaBingComentarios);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/empresaBingComentarios/{id}").buildAndExpand(empresaBingComentarios.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/empresaBingComentarios/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmpresaBingComentarios> updateEmpresaBingComentarios(@PathVariable("id") Integer id, @RequestBody EmpresaBingComentarios empresaBingComentarios) throws Exception {
		System.out.println("Updating EmpresaBingComentarios " + id);

		EmpresaBingComentarios currentEmpresaBingComentarios = empresaBingComentariosService.buscarById(new EmpresaBingComentarios(id));

		if (currentEmpresaBingComentarios == null) {
			System.out.println("EmpresaBingComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaBingComentarios>(HttpStatus.NOT_FOUND);
		}

		empresaBingComentariosService.guardar(empresaBingComentarios);
		return new ResponseEntity<EmpresaBingComentarios>(currentEmpresaBingComentarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaBingComentarios/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpresaBingComentarios> deleteEmpresaBingComentarios(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting EmpresaBingComentarios with id " + id);

		EmpresaBingComentarios empresaBingComentarios = empresaBingComentariosService.buscarById(new EmpresaBingComentarios(id));
		if (empresaBingComentarios == null) {
			System.out.println("Unable to delete. EmpresaBingComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaBingComentarios>(HttpStatus.NOT_FOUND);
		}

		empresaBingComentariosService.eliminar(new EmpresaBingComentarios(id));
		return new ResponseEntity<EmpresaBingComentarios>(HttpStatus.NO_CONTENT);
	}
	
}
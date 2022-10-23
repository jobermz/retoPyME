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

import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogleComentarios;
import pe.com.bbva.hackaton.core.service.EmpresaGoogleComentariosService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Empresa Google Comentarios
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class EmpresaGoogleComentariosRestController {
	
	@Autowired
	private EmpresaGoogleComentariosService empresaGoogleComentariosService;
	
	@RequestMapping(value = "/empresaGoogleComentarios/", method = RequestMethod.GET)
	public ResponseEntity<List<EmpresaGoogleComentarios>> listAllEmpresaGoogleComentarioss() throws Exception {
		List<EmpresaGoogleComentarios> empresaGoogleComentarioss = empresaGoogleComentariosService.buscar(new EmpresaGoogleComentarios(), null);
		if (empresaGoogleComentarioss.isEmpty()) {
			return new ResponseEntity<List<EmpresaGoogleComentarios>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpresaGoogleComentarios>>(empresaGoogleComentarioss, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogleComentarios/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGoogleComentarios> getEmpresaGoogleComentarios(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching EmpresaGoogleComentarios with id " + id);
		EmpresaGoogleComentarios empresaGoogleComentarios = empresaGoogleComentariosService.buscarById(new EmpresaGoogleComentarios(id));
		if (empresaGoogleComentarios == null) {
			System.out.println("EmpresaGoogleComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogleComentarios>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmpresaGoogleComentarios>(empresaGoogleComentarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogleComentarios/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmpresaGoogleComentarios(@RequestBody EmpresaGoogleComentarios empresaGoogleComentarios, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating EmpresaGoogleComentarios " + empresaGoogleComentarios.getStrNombre());
		if (empresaGoogleComentariosService.buscarById(empresaGoogleComentarios) != null) {
			//System.out.println("A EmpresaGoogleComentarios with name " + empresaGoogleComentarios.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		empresaGoogleComentariosService.guardar(empresaGoogleComentarios);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/empresaGoogleComentarios/{id}").buildAndExpand(empresaGoogleComentarios.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/empresaGoogleComentarios/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmpresaGoogleComentarios> updateEmpresaGoogleComentarios(@PathVariable("id") Integer id, @RequestBody EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		System.out.println("Updating EmpresaGoogleComentarios " + id);

		EmpresaGoogleComentarios currentEmpresaGoogleComentarios = empresaGoogleComentariosService.buscarById(new EmpresaGoogleComentarios(id));

		if (currentEmpresaGoogleComentarios == null) {
			System.out.println("EmpresaGoogleComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogleComentarios>(HttpStatus.NOT_FOUND);
		}

		empresaGoogleComentariosService.guardar(empresaGoogleComentarios);
		return new ResponseEntity<EmpresaGoogleComentarios>(currentEmpresaGoogleComentarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresaGoogleComentarios/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpresaGoogleComentarios> deleteEmpresaGoogleComentarios(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting EmpresaGoogleComentarios with id " + id);

		EmpresaGoogleComentarios empresaGoogleComentarios = empresaGoogleComentariosService.buscarById(new EmpresaGoogleComentarios(id));
		if (empresaGoogleComentarios == null) {
			System.out.println("Unable to delete. EmpresaGoogleComentarios with id " + id + " not found");
			return new ResponseEntity<EmpresaGoogleComentarios>(HttpStatus.NOT_FOUND);
		}

		empresaGoogleComentariosService.eliminar(new EmpresaGoogleComentarios(id));
		return new ResponseEntity<EmpresaGoogleComentarios>(HttpStatus.NO_CONTENT);
	}
	
}
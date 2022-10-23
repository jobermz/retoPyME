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

import pe.com.bbva.hackaton.core.model.entity.Dataset;
import pe.com.bbva.hackaton.core.service.DatasetService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Dataset
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class DatasetRestController {
	
	@Autowired
	private DatasetService datasetService;

	@RequestMapping(value = "/tcs/", method = RequestMethod.GET)
	public ResponseEntity<Void> tcs() throws Exception {
		
		datasetService.tcs();
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dataset/", method = RequestMethod.GET)
	public ResponseEntity<List<Dataset>> listAllDatasets() throws Exception {
		List<Dataset> datasets = datasetService.buscar(new Dataset(), null);
		if (datasets.isEmpty()) {
			return new ResponseEntity<List<Dataset>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Dataset>>(datasets, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dataset/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dataset> getDataset(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Dataset with id " + id);
		Dataset dataset = datasetService.buscarById(new Dataset(id));
		if (dataset == null) {
			System.out.println("Dataset with id " + id + " not found");
			return new ResponseEntity<Dataset>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Dataset>(dataset, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dataset/", method = RequestMethod.POST)
	public ResponseEntity<Void> createDataset(@RequestBody Dataset dataset, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Dataset " + dataset.getStrNombre());
		if (datasetService.buscarById(dataset) != null) {
			//System.out.println("A Dataset with name " + dataset.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		datasetService.guardar(dataset);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/dataset/{id}").buildAndExpand(dataset.getSrlId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/dataset/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Dataset> updateDataset(@PathVariable("id") Integer id, @RequestBody Dataset dataset) throws Exception {
		System.out.println("Updating Dataset " + id);

		Dataset currentDataset = datasetService.buscarById(new Dataset(id));

		if (currentDataset == null) {
			System.out.println("Dataset with id " + id + " not found");
			return new ResponseEntity<Dataset>(HttpStatus.NOT_FOUND);
		}

		datasetService.guardar(dataset);
		return new ResponseEntity<Dataset>(currentDataset, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dataset/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Dataset> deleteDataset(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Dataset with id " + id);

		Dataset dataset = datasetService.buscarById(new Dataset(id));
		if (dataset == null) {
			System.out.println("Unable to delete. Dataset with id " + id + " not found");
			return new ResponseEntity<Dataset>(HttpStatus.NOT_FOUND);
		}

		datasetService.eliminar(new Dataset(id));
		return new ResponseEntity<Dataset>(HttpStatus.NO_CONTENT);
	}
	
}
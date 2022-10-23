package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;

import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.Dataset;
import pe.com.bbva.hackaton.core.bean.TcsResponse;
import pe.com.bbva.hackaton.core.dao.DatasetDao;
import pe.com.bbva.hackaton.core.service.DatasetService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@Service
@EnableTransactionManagement
@Transactional
public class DatasetServiceImpl implements DatasetService {
	
	@Autowired
	private DatasetDao datasetDao;
	
	@Autowired
	protected RestTemplate restTemplate;

	public void tcs() throws Exception {
		System.out.println("consultarDatosNegocio: inicio");
		String urlTcs = "http://34.201.39.136:8080/dataset/4037";
		String bodyTcs = CadenaUtil.localFileOpen("body.txt");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(bodyTcs, headers);
		ResponseEntity<Dataset> response = restTemplate.exchange(urlTcs, HttpMethod.PUT,
				entity, Dataset.class);

		System.out.println("consultarDatosNegocio: fin");
		System.out.println("RESPONSE: "+response.getBody());
		
		//return response.getBody();
	}
	
	
	
	public List<Dataset> buscar(Dataset dataset, PaginacionDto paginacionDto) throws Exception {
		try {
			return datasetDao.buscar(dataset, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Dataset buscarById(Dataset dataset) throws Exception {
		try {
			return datasetDao.buscarById(dataset);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Dataset dataset) throws Exception {
		try {
			datasetDao.guardar(dataset);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Dataset dataset) throws Exception {
		try {
			datasetDao.eliminar(dataset);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

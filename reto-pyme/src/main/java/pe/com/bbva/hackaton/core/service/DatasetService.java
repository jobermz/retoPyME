package pe.com.bbva.hackaton.core.service;

import java.util.List;
import pe.com.bbva.hackaton.core.model.entity.Dataset;
import pe.com.bbva.hackaton.common.PaginacionDto;


public interface DatasetService {
	
	public void tcs() throws Exception;
	public List<Dataset> buscar(Dataset dataset, PaginacionDto paginacionDto) throws Exception;
	public Dataset buscarById(Dataset dataset) throws Exception;
	public void guardar(Dataset dataset) throws Exception;
	public void eliminar(Dataset dataset) throws Exception;
	
}

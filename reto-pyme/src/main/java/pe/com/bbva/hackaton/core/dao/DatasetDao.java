package pe.com.bbva.hackaton.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.bbva.hackaton.core.model.entity.Dataset;
import pe.com.bbva.hackaton.common.PaginacionDto;

@Service
public interface DatasetDao {
	
	public List<Dataset> buscar(Dataset dataset, PaginacionDto paginacionDto) throws Exception;
	public Dataset buscarById(Dataset dataset) throws Exception;
	public void guardar(Dataset dataset) throws Exception;
	public void eliminar(Dataset dataset) throws Exception;
	
}

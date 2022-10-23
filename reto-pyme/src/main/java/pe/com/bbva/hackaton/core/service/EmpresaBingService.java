package pe.com.bbva.hackaton.core.service;

import java.util.List;
import pe.com.bbva.hackaton.core.model.entity.EmpresaBing;
import pe.com.bbva.hackaton.common.PaginacionDto;


public interface EmpresaBingService {
	
	public List<EmpresaBing> buscar(EmpresaBing empresaBing, PaginacionDto paginacionDto) throws Exception;
	public EmpresaBing buscarById(EmpresaBing empresaBing) throws Exception;
	public void guardar(EmpresaBing empresaBing) throws Exception;
	public void eliminar(EmpresaBing empresaBing) throws Exception;
		
}

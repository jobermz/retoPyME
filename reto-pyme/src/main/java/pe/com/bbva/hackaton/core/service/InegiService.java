package pe.com.bbva.hackaton.core.service;

import java.util.List;
import pe.com.bbva.hackaton.core.model.entity.Inegi;
import pe.com.bbva.hackaton.common.PaginacionDto;


public interface InegiService {
	
	public List<Inegi> buscar(Inegi inegi, PaginacionDto paginacionDto) throws Exception;
	public Inegi buscarById(Inegi inegi) throws Exception;
	public void guardar(Inegi inegi) throws Exception;
	public void eliminar(Inegi inegi) throws Exception;
		
}

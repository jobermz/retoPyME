package pe.com.bbva.hackaton.core.service;

import java.util.List;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogleComentarios;
import pe.com.bbva.hackaton.common.PaginacionDto;


public interface EmpresaGoogleComentariosService {
	
	public List<EmpresaGoogleComentarios> buscar(EmpresaGoogleComentarios empresaGoogleComentarios, PaginacionDto paginacionDto) throws Exception;
	public EmpresaGoogleComentarios buscarById(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
	public void guardar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
	public void eliminar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
		
}

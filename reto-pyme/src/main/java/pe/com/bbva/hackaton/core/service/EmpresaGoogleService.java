package pe.com.bbva.hackaton.core.service;

import java.util.List;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
import pe.com.bbva.hackaton.common.PaginacionDto;


public interface EmpresaGoogleService {
	
	public List<EmpresaGoogle> buscar(EmpresaGoogle empresaGoogle, PaginacionDto paginacionDto) throws Exception;
	public EmpresaGoogle buscarById(EmpresaGoogle empresaGoogle) throws Exception;
	public void guardar(EmpresaGoogle empresaGoogle) throws Exception;
	public void eliminar(EmpresaGoogle empresaGoogle) throws Exception;
		
}

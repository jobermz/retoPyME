package pe.com.bbva.hackaton.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
import pe.com.bbva.hackaton.common.PaginacionDto;

@Service
public interface EmpresaGoogleDao {
	
	public List<EmpresaGoogle> buscar(EmpresaGoogle empresaGoogle, PaginacionDto paginacionDto) throws Exception;
	public EmpresaGoogle buscarById(EmpresaGoogle empresaGoogle) throws Exception;
	public void guardar(EmpresaGoogle empresaGoogle) throws Exception;
	public void eliminar(EmpresaGoogle empresaGoogle) throws Exception;
		
}

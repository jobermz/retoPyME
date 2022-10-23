package pe.com.bbva.hackaton.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogleComentarios;
import pe.com.bbva.hackaton.common.PaginacionDto;

@Service
public interface EmpresaGoogleComentariosDao {
	
	public List<EmpresaGoogleComentarios> buscar(EmpresaGoogleComentarios empresaGoogleComentarios, PaginacionDto paginacionDto) throws Exception;
	public EmpresaGoogleComentarios buscarById(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
	public void guardar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
	public void eliminar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception;
		
}

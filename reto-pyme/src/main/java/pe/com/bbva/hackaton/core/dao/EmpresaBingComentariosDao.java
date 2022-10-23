package pe.com.bbva.hackaton.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.bbva.hackaton.core.model.entity.EmpresaBingComentarios;
import pe.com.bbva.hackaton.common.PaginacionDto;

@Service
public interface EmpresaBingComentariosDao {
	
	public List<EmpresaBingComentarios> buscar(EmpresaBingComentarios empresaBingComentarios, PaginacionDto paginacionDto) throws Exception;
	public EmpresaBingComentarios buscarById(EmpresaBingComentarios empresaBingComentarios) throws Exception;
	public void guardar(EmpresaBingComentarios empresaBingComentarios) throws Exception;
	public void eliminar(EmpresaBingComentarios empresaBingComentarios) throws Exception;
		
}

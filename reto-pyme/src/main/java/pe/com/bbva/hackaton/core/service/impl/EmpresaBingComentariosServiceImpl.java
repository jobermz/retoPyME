package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.EmpresaBingComentarios;
import pe.com.bbva.hackaton.core.dao.EmpresaBingComentariosDao;
import pe.com.bbva.hackaton.core.service.EmpresaBingComentariosService;

@Service
@EnableTransactionManagement
@Transactional
public class EmpresaBingComentariosServiceImpl implements EmpresaBingComentariosService {
	
	@Autowired
	private EmpresaBingComentariosDao empresaBingComentariosDao;
	
	public List<EmpresaBingComentarios> buscar(EmpresaBingComentarios empresaBingComentarios, PaginacionDto paginacionDto) throws Exception {
		try {
			return empresaBingComentariosDao.buscar(empresaBingComentarios, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public EmpresaBingComentarios buscarById(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		try {
			return empresaBingComentariosDao.buscarById(empresaBingComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		try {
			empresaBingComentariosDao.guardar(empresaBingComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		try {
			empresaBingComentariosDao.eliminar(empresaBingComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

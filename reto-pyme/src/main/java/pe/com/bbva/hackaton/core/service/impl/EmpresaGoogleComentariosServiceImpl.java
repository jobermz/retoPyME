package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogleComentarios;
import pe.com.bbva.hackaton.core.dao.EmpresaGoogleComentariosDao;
import pe.com.bbva.hackaton.core.service.EmpresaGoogleComentariosService;

@Service
@EnableTransactionManagement
@Transactional
public class EmpresaGoogleComentariosServiceImpl implements EmpresaGoogleComentariosService {
	
	@Autowired
	private EmpresaGoogleComentariosDao empresaGoogleComentariosDao;
	
	public List<EmpresaGoogleComentarios> buscar(EmpresaGoogleComentarios empresaGoogleComentarios, PaginacionDto paginacionDto) throws Exception {
		try {
			return empresaGoogleComentariosDao.buscar(empresaGoogleComentarios, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public EmpresaGoogleComentarios buscarById(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		try {
			return empresaGoogleComentariosDao.buscarById(empresaGoogleComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		try {
			empresaGoogleComentariosDao.guardar(empresaGoogleComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		try {
			empresaGoogleComentariosDao.eliminar(empresaGoogleComentarios);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

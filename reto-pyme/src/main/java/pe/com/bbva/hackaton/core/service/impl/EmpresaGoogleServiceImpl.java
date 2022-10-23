package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
import pe.com.bbva.hackaton.core.dao.EmpresaGoogleDao;
import pe.com.bbva.hackaton.core.service.EmpresaGoogleService;

@Service
@EnableTransactionManagement
@Transactional
public class EmpresaGoogleServiceImpl implements EmpresaGoogleService {
	
	@Autowired
	private EmpresaGoogleDao empresaGoogleDao;
	
	public List<EmpresaGoogle> buscar(EmpresaGoogle empresaGoogle, PaginacionDto paginacionDto) throws Exception {
		try {
			return empresaGoogleDao.buscar(empresaGoogle, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public EmpresaGoogle buscarById(EmpresaGoogle empresaGoogle) throws Exception {
		try {
			return empresaGoogleDao.buscarById(empresaGoogle);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(EmpresaGoogle empresaGoogle) throws Exception {
		try {
			empresaGoogleDao.guardar(empresaGoogle);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaGoogle empresaGoogle) throws Exception {
		try {
			empresaGoogleDao.eliminar(empresaGoogle);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

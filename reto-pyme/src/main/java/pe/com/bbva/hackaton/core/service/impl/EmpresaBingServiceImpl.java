package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.EmpresaBing;
import pe.com.bbva.hackaton.core.dao.EmpresaBingDao;
import pe.com.bbva.hackaton.core.service.EmpresaBingService;

@Service
@EnableTransactionManagement
@Transactional
public class EmpresaBingServiceImpl implements EmpresaBingService {
	
	@Autowired
	private EmpresaBingDao empresaBingDao;
	
	public List<EmpresaBing> buscar(EmpresaBing empresaBing, PaginacionDto paginacionDto) throws Exception {
		try {
			return empresaBingDao.buscar(empresaBing, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public EmpresaBing buscarById(EmpresaBing empresaBing) throws Exception {
		try {
			return empresaBingDao.buscarById(empresaBing);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(EmpresaBing empresaBing) throws Exception {
		try {
			empresaBingDao.guardar(empresaBing);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaBing empresaBing) throws Exception {
		try {
			empresaBingDao.eliminar(empresaBing);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

package pe.com.bbva.hackaton.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.Inegi;
import pe.com.bbva.hackaton.core.dao.InegiDao;
import pe.com.bbva.hackaton.core.service.InegiService;

@Service
@EnableTransactionManagement
@Transactional
public class InegiServiceImpl implements InegiService {
	
	@Autowired
	private InegiDao inegiDao;
	
	public List<Inegi> buscar(Inegi inegi, PaginacionDto paginacionDto) throws Exception {
		try {
			return inegiDao.buscar(inegi, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Inegi buscarById(Inegi inegi) throws Exception {
		try {
			return inegiDao.buscarById(inegi);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Inegi inegi) throws Exception {
		try {
			inegiDao.guardar(inegi);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Inegi inegi) throws Exception {
		try {
			inegiDao.eliminar(inegi);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}

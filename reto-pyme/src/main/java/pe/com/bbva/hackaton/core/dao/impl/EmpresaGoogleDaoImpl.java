package pe.com.bbva.hackaton.core.dao.impl;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import pe.com.bbva.hackaton.common.PaginacionDto;
import pe.com.bbva.hackaton.common.CadenaUtil;
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
import pe.com.bbva.hackaton.core.dao.EmpresaGoogleDao;

@Repository
public class EmpresaGoogleDaoImpl implements EmpresaGoogleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmpresaGoogle> buscar(EmpresaGoogle empresaGoogle, PaginacionDto paginacionDto) throws Exception {
		List<EmpresaGoogle> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM EmpresaGoogle ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(empresaGoogle.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(empresaGoogle.getIdDataset() != null) {
				sbHql.append("AND idDataset = :idDataset ");
			}
			if(CadenaUtil.getStrNull(empresaGoogle.getStrNombComp()) != null) {
				sbHql.append("AND strNombComp like :strNombComp ");
			}
			if(CadenaUtil.getStrNull(empresaGoogle.getStrDireccion()) != null) {
				sbHql.append("AND strDireccion like :strDireccion ");
			}
			if(CadenaUtil.getInteNull(empresaGoogle.getIntCalifiEstrellas()) != null) {
				sbHql.append("AND intCalifiEstrellas = :intCalifiEstrellas ");
			}
			if(CadenaUtil.getInteNull(empresaGoogle.getIntSentimientoComentarios()) != null) {
				sbHql.append("AND intSentimientoComentarios = :intSentimientoComentarios ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(empresaGoogle.getSrlId()) != null) {
				query.setParameter("srlId", empresaGoogle.getSrlId());
			}
			if(empresaGoogle.getIdDataset() != null) {
				query.setParameter("idDataset", empresaGoogle.getIdDataset());
			}
			if(CadenaUtil.getStrNull(empresaGoogle.getStrNombComp()) != null) {
				query.setParameter("strNombComp", empresaGoogle.getStrNombComp());
			}
			if(CadenaUtil.getStrNull(empresaGoogle.getStrDireccion()) != null) {
				query.setParameter("strDireccion", empresaGoogle.getStrDireccion());
			}
			if(CadenaUtil.getInteNull(empresaGoogle.getIntCalifiEstrellas()) != null) {
				query.setParameter("intCalifiEstrellas", empresaGoogle.getIntCalifiEstrellas());
			}
			if(CadenaUtil.getInteNull(empresaGoogle.getIntSentimientoComentarios()) != null) {
				query.setParameter("intSentimientoComentarios", empresaGoogle.getIntSentimientoComentarios());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<EmpresaGoogle>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public EmpresaGoogle buscarById(EmpresaGoogle empresaGoogle) throws Exception {
		EmpresaGoogle entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(EmpresaGoogle.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", empresaGoogle.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (EmpresaGoogle)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(EmpresaGoogle empresaGoogle) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(empresaGoogle);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaGoogle empresaGoogle) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(empresaGoogle);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

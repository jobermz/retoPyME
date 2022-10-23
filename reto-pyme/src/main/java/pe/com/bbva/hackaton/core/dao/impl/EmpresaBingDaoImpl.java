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
import pe.com.bbva.hackaton.core.model.entity.EmpresaBing;
import pe.com.bbva.hackaton.core.dao.EmpresaBingDao;

@Repository
public class EmpresaBingDaoImpl implements EmpresaBingDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmpresaBing> buscar(EmpresaBing empresaBing, PaginacionDto paginacionDto) throws Exception {
		List<EmpresaBing> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM EmpresaBing ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(empresaBing.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(empresaBing.getIdDataset() != null) {
				sbHql.append("AND idDataset = :idDataset ");
			}
			if(CadenaUtil.getStrNull(empresaBing.getStrNombComp()) != null) {
				sbHql.append("AND strNombComp like :strNombComp ");
			}
			if(CadenaUtil.getStrNull(empresaBing.getStrDireccion()) != null) {
				sbHql.append("AND strDireccion like :strDireccion ");
			}
			if(CadenaUtil.getInteNull(empresaBing.getIntCalifiEstrellas()) != null) {
				sbHql.append("AND intCalifiEstrellas = :intCalifiEstrellas ");
			}
			if(CadenaUtil.getInteNull(empresaBing.getIntSentimientoComentarios()) != null) {
				sbHql.append("AND intSentimientoComentarios = :intSentimientoComentarios ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(empresaBing.getSrlId()) != null) {
				query.setParameter("srlId", empresaBing.getSrlId());
			}
			if(empresaBing.getIdDataset() != null) {
				query.setParameter("idDataset", empresaBing.getIdDataset());
			}
			if(CadenaUtil.getStrNull(empresaBing.getStrNombComp()) != null) {
				query.setParameter("strNombComp", empresaBing.getStrNombComp());
			}
			if(CadenaUtil.getStrNull(empresaBing.getStrDireccion()) != null) {
				query.setParameter("strDireccion", empresaBing.getStrDireccion());
			}
			if(CadenaUtil.getInteNull(empresaBing.getIntCalifiEstrellas()) != null) {
				query.setParameter("intCalifiEstrellas", empresaBing.getIntCalifiEstrellas());
			}
			if(CadenaUtil.getInteNull(empresaBing.getIntSentimientoComentarios()) != null) {
				query.setParameter("intSentimientoComentarios", empresaBing.getIntSentimientoComentarios());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<EmpresaBing>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public EmpresaBing buscarById(EmpresaBing empresaBing) throws Exception {
		EmpresaBing entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(EmpresaBing.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", empresaBing.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (EmpresaBing)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(EmpresaBing empresaBing) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(empresaBing);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaBing empresaBing) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(empresaBing);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

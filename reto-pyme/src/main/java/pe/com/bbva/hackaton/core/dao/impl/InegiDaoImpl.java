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
import pe.com.bbva.hackaton.core.model.entity.Inegi;
import pe.com.bbva.hackaton.core.dao.InegiDao;

@Repository
public class InegiDaoImpl implements InegiDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Inegi> buscar(Inegi inegi, PaginacionDto paginacionDto) throws Exception {
		List<Inegi> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Inegi ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(inegi.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(CadenaUtil.getInteNull(inegi.getIntIdDataset()) != null) {
				sbHql.append("AND intIdDataset = :intIdDataset ");
			}
			if(CadenaUtil.getStrNull(inegi.getStrNombComp()) != null) {
				sbHql.append("AND strNombComp like :strNombComp ");
			}
			if(CadenaUtil.getStrNull(inegi.getStrDireccion()) != null) {
				sbHql.append("AND strDireccion like :strDireccion ");
			}
			if(CadenaUtil.getInteNull(inegi.getIntEstratoPersoOcupado()) != null) {
				sbHql.append("AND intEstratoPersoOcupado = :intEstratoPersoOcupado ");
			}
			if(CadenaUtil.getInteNull(inegi.getIntTipoEstablecimiento()) != null) {
				sbHql.append("AND intTipoEstablecimiento = :intTipoEstablecimiento ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(inegi.getSrlId()) != null) {
				query.setParameter("srlId", inegi.getSrlId());
			}
			if(CadenaUtil.getInteNull(inegi.getIntIdDataset()) != null) {
				query.setParameter("intIdDataset", inegi.getIntIdDataset());
			}
			if(CadenaUtil.getStrNull(inegi.getStrNombComp()) != null) {
				query.setParameter("strNombComp", inegi.getStrNombComp());
			}
			if(CadenaUtil.getStrNull(inegi.getStrDireccion()) != null) {
				query.setParameter("strDireccion", inegi.getStrDireccion());
			}
			if(CadenaUtil.getInteNull(inegi.getIntEstratoPersoOcupado()) != null) {
				query.setParameter("intEstratoPersoOcupado", inegi.getIntEstratoPersoOcupado());
			}
			if(CadenaUtil.getInteNull(inegi.getIntTipoEstablecimiento()) != null) {
				query.setParameter("intTipoEstablecimiento", inegi.getIntTipoEstablecimiento());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Inegi>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Inegi buscarById(Inegi inegi) throws Exception {
		Inegi entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Inegi.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", inegi.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Inegi)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Inegi inegi) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(inegi);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Inegi inegi) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(inegi);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

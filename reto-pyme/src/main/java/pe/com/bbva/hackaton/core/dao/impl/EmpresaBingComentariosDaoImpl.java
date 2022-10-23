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
import pe.com.bbva.hackaton.core.model.entity.EmpresaBingComentarios;
import pe.com.bbva.hackaton.core.dao.EmpresaBingComentariosDao;

@Repository
public class EmpresaBingComentariosDaoImpl implements EmpresaBingComentariosDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmpresaBingComentarios> buscar(EmpresaBingComentarios empresaBingComentarios, PaginacionDto paginacionDto) throws Exception {
		List<EmpresaBingComentarios> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM EmpresaBingComentarios ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(empresaBingComentarios.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(empresaBingComentarios.getIdEmpresaBing() != null) {
				sbHql.append("AND idEmpresaBing = :idEmpresaBing ");
			}
			if(CadenaUtil.getStrNull(empresaBingComentarios.getStrComentario()) != null) {
				sbHql.append("AND strComentario like :strComentario ");
			}
			if(CadenaUtil.getInteNull(empresaBingComentarios.getIntSentimientoComentarios()) != null) {
				sbHql.append("AND intSentimientoComentarios = :intSentimientoComentarios ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(empresaBingComentarios.getSrlId()) != null) {
				query.setParameter("srlId", empresaBingComentarios.getSrlId());
			}
			if(empresaBingComentarios.getIdEmpresaBing() != null) {
				query.setParameter("idEmpresaBing", empresaBingComentarios.getIdEmpresaBing());
			}
			if(CadenaUtil.getStrNull(empresaBingComentarios.getStrComentario()) != null) {
				query.setParameter("strComentario", empresaBingComentarios.getStrComentario());
			}
			if(CadenaUtil.getInteNull(empresaBingComentarios.getIntSentimientoComentarios()) != null) {
				query.setParameter("intSentimientoComentarios", empresaBingComentarios.getIntSentimientoComentarios());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<EmpresaBingComentarios>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public EmpresaBingComentarios buscarById(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		EmpresaBingComentarios entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(EmpresaBingComentarios.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", empresaBingComentarios.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (EmpresaBingComentarios)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(empresaBingComentarios);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaBingComentarios empresaBingComentarios) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(empresaBingComentarios);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

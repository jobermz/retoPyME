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
import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogleComentarios;
import pe.com.bbva.hackaton.core.dao.EmpresaGoogleComentariosDao;

@Repository
public class EmpresaGoogleComentariosDaoImpl implements EmpresaGoogleComentariosDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmpresaGoogleComentarios> buscar(EmpresaGoogleComentarios empresaGoogleComentarios, PaginacionDto paginacionDto) throws Exception {
		List<EmpresaGoogleComentarios> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM EmpresaGoogleComentarios ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(empresaGoogleComentarios.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(empresaGoogleComentarios.getIdEmpresaGoogle() != null) {
				sbHql.append("AND idEmpresaGoogle = :idEmpresaGoogle ");
			}
			if(CadenaUtil.getStrNull(empresaGoogleComentarios.getStrComentario()) != null) {
				sbHql.append("AND strComentario like :strComentario ");
			}
			if(CadenaUtil.getInteNull(empresaGoogleComentarios.getIntSentimientoComentarios()) != null) {
				sbHql.append("AND intSentimientoComentarios = :intSentimientoComentarios ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(empresaGoogleComentarios.getSrlId()) != null) {
				query.setParameter("srlId", empresaGoogleComentarios.getSrlId());
			}
			if(empresaGoogleComentarios.getIdEmpresaGoogle() != null) {
				query.setParameter("idEmpresaGoogle", empresaGoogleComentarios.getIdEmpresaGoogle());
			}
			if(CadenaUtil.getStrNull(empresaGoogleComentarios.getStrComentario()) != null) {
				query.setParameter("strComentario", empresaGoogleComentarios.getStrComentario());
			}
			if(CadenaUtil.getInteNull(empresaGoogleComentarios.getIntSentimientoComentarios()) != null) {
				query.setParameter("intSentimientoComentarios", empresaGoogleComentarios.getIntSentimientoComentarios());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<EmpresaGoogleComentarios>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public EmpresaGoogleComentarios buscarById(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		EmpresaGoogleComentarios entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(EmpresaGoogleComentarios.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", empresaGoogleComentarios.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (EmpresaGoogleComentarios)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(empresaGoogleComentarios);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(EmpresaGoogleComentarios empresaGoogleComentarios) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(empresaGoogleComentarios);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

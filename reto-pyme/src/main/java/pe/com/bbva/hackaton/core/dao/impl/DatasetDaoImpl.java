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
import pe.com.bbva.hackaton.core.model.entity.Dataset;
import pe.com.bbva.hackaton.core.dao.DatasetDao;

@Repository
public class DatasetDaoImpl implements DatasetDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Dataset> buscar(Dataset dataset, PaginacionDto paginacionDto) throws Exception {
		List<Dataset> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Dataset ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(dataset.getSrlId()) != null) {
				sbHql.append("AND srlId = :srlId ");
			}
			if(CadenaUtil.getInteNull(dataset.getIntIndex()) != null) {
				sbHql.append("AND intIndex = :intIndex ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre1()) != null) {
				sbHql.append("AND strNombre1 like :strNombre1 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre2()) != null) {
				sbHql.append("AND strNombre2 like :strNombre2 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre3()) != null) {
				sbHql.append("AND strNombre3 like :strNombre3 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion1()) != null) {
				sbHql.append("AND strDireccion1 like :strDireccion1 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion2()) != null) {
				sbHql.append("AND strDireccion2 like :strDireccion2 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion3()) != null) {
				sbHql.append("AND strDireccion3 like :strDireccion3 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrColonia()) != null) {
				sbHql.append("AND strColonia like :strColonia ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrMunicipioDel()) != null) {
				sbHql.append("AND strMunicipioDel like :strMunicipioDel ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrCp()) != null) {
				sbHql.append("AND strCp like :strCp ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrEntreCalle1()) != null) {
				sbHql.append("AND strEntreCalle1 like :strEntreCalle1 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrEntreCalle2()) != null) {
				sbHql.append("AND strEntreCalle2 like :strEntreCalle2 ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrEstado()) != null) {
				sbHql.append("AND strEstado like :strEstado ");
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombComp()) != null) {
				sbHql.append("AND strNombComp like :strNombComp ");
			}
			Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(dataset.getSrlId()) != null) {
				query.setParameter("srlId", dataset.getSrlId());
			}
			if(CadenaUtil.getInteNull(dataset.getIntIndex()) != null) {
				query.setParameter("intIndex", dataset.getIntIndex());
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre1()) != null) {
				query.setParameter("strNombre1", dataset.getStrNombre1());
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre2()) != null) {
				query.setParameter("strNombre2", dataset.getStrNombre2());
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombre3()) != null) {
				query.setParameter("strNombre3", dataset.getStrNombre3());
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion1()) != null) {
				query.setParameter("strDireccion1", dataset.getStrDireccion1());
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion2()) != null) {
				query.setParameter("strDireccion2", dataset.getStrDireccion2());
			}
			if(CadenaUtil.getStrNull(dataset.getStrDireccion3()) != null) {
				query.setParameter("strDireccion3", dataset.getStrDireccion3());
			}
			if(CadenaUtil.getStrNull(dataset.getStrColonia()) != null) {
				query.setParameter("strColonia", dataset.getStrColonia());
			}
			if(CadenaUtil.getStrNull(dataset.getStrMunicipioDel()) != null) {
				query.setParameter("strMunicipioDel", dataset.getStrMunicipioDel());
			}
			if(CadenaUtil.getStrNull(dataset.getStrCp()) != null) {
				query.setParameter("strCp", dataset.getStrCp());
			}
			if(CadenaUtil.getStrNull(dataset.getStrEntreCalle1()) != null) {
				query.setParameter("strEntreCalle1", dataset.getStrEntreCalle1());
			}
			if(CadenaUtil.getStrNull(dataset.getStrEntreCalle2()) != null) {
				query.setParameter("strEntreCalle2", dataset.getStrEntreCalle2());
			}
			if(CadenaUtil.getStrNull(dataset.getStrEstado()) != null) {
				query.setParameter("strEstado", dataset.getStrEstado());
			}
			if(CadenaUtil.getStrNull(dataset.getStrNombComp()) != null) {
				query.setParameter("strNombComp", dataset.getStrNombComp());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Dataset>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Dataset buscarById(Dataset dataset) throws Exception {
		Dataset entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Dataset.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlId", dataset.getSrlId()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Dataset)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Dataset dataset) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(dataset);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Dataset dataset) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(dataset);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}

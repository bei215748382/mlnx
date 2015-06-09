package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo4 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mlnxMS.core.Userinfo4
 * @author MyEclipse Persistence Tools
 */
public class Userinfo4DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Userinfo4DAO.class);
	// property constants
	public static final String UCOMPANY = "ucompany";
	public static final String UOCCUPATION = "uoccupation";
	public static final String UPOSITION = "uposition";
	public static final String UREVENUE = "urevenue";

	public void save(Userinfo4 transientInstance) {
		log.debug("saving Userinfo4 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo4 persistentInstance) {
		log.debug("deleting Userinfo4 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo4 findById(java.lang.Integer id) {
		log.debug("getting Userinfo4 instance with id: " + id);
		try {
			Userinfo4 instance = (Userinfo4) getSession().get(
					"com.mlnxMS.core.Userinfo4", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo4> findByExample(Userinfo4 instance) {
		log.debug("finding Userinfo4 instance by example");
		try {
			List<Userinfo4> results = (List<Userinfo4>) getSession()
					.createCriteria("com.mlnxMS.core.Userinfo4")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Userinfo4 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo4 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo4> findByUcompany(Object ucompany) {
		return findByProperty(UCOMPANY, ucompany);
	}

	public List<Userinfo4> findByUoccupation(Object uoccupation) {
		return findByProperty(UOCCUPATION, uoccupation);
	}

	public List<Userinfo4> findByUposition(Object uposition) {
		return findByProperty(UPOSITION, uposition);
	}

	public List<Userinfo4> findByUrevenue(Object urevenue) {
		return findByProperty(UREVENUE, urevenue);
	}

	public List findAll() {
		log.debug("finding all Userinfo4 instances");
		try {
			String queryString = "from Userinfo4";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo4 merge(Userinfo4 detachedInstance) {
		log.debug("merging Userinfo4 instance");
		try {
			Userinfo4 result = (Userinfo4) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo4 instance) {
		log.debug("attaching dirty Userinfo4 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo4 instance) {
		log.debug("attaching clean Userinfo4 instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
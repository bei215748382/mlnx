package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo3 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mlnxMS.core.Userinfo3
 * @author MyEclipse Persistence Tools
 */
public class Userinfo3DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Userinfo3DAO.class);
	// property constants
	public static final String UEDUCATION = "ueducation";
	public static final String USCHOOL = "uschool";

	public void save(Userinfo3 transientInstance) {
		log.debug("saving Userinfo3 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo3 persistentInstance) {
		log.debug("deleting Userinfo3 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo3 findById(java.lang.Integer id) {
		log.debug("getting Userinfo3 instance with id: " + id);
		try {
			Userinfo3 instance = (Userinfo3) getSession().get(
					"com.mlnxMS.core.Userinfo3", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo3> findByExample(Userinfo3 instance) {
		log.debug("finding Userinfo3 instance by example");
		try {
			List<Userinfo3> results = (List<Userinfo3>) getSession()
					.createCriteria("com.mlnxMS.core.Userinfo3")
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
		log.debug("finding Userinfo3 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo3 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo3> findByUeducation(Object ueducation) {
		return findByProperty(UEDUCATION, ueducation);
	}

	public List<Userinfo3> findByUschool(Object uschool) {
		return findByProperty(USCHOOL, uschool);
	}

	public List findAll() {
		log.debug("finding all Userinfo3 instances");
		try {
			String queryString = "from Userinfo3";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo3 merge(Userinfo3 detachedInstance) {
		log.debug("merging Userinfo3 instance");
		try {
			Userinfo3 result = (Userinfo3) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo3 instance) {
		log.debug("attaching dirty Userinfo3 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo3 instance) {
		log.debug("attaching clean Userinfo3 instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo5 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mlnxMS.core.Userinfo5
 * @author MyEclipse Persistence Tools
 */
public class Userinfo5DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Userinfo5DAO.class);
	// property constants
	public static final String UADDRESS = "uaddress";
	public static final String UZIPCODE = "uzipcode";
	public static final String UBIO = "ubio";
	public static final String UINTEREST = "uinterest";

	public void save(Userinfo5 transientInstance) {
		log.debug("saving Userinfo5 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo5 persistentInstance) {
		log.debug("deleting Userinfo5 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo5 findById(java.lang.Integer id) {
		log.debug("getting Userinfo5 instance with id: " + id);
		try {
			Userinfo5 instance = (Userinfo5) getSession().get(
					"com.mlnxMS.core.Userinfo5", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo5> findByExample(Userinfo5 instance) {
		log.debug("finding Userinfo5 instance by example");
		try {
			List<Userinfo5> results = (List<Userinfo5>) getSession()
					.createCriteria("com.mlnxMS.core.Userinfo5")
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
		log.debug("finding Userinfo5 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo5 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo5> findByUaddress(Object uaddress) {
		return findByProperty(UADDRESS, uaddress);
	}

	public List<Userinfo5> findByUzipcode(Object uzipcode) {
		return findByProperty(UZIPCODE, uzipcode);
	}

	public List<Userinfo5> findByUbio(Object ubio) {
		return findByProperty(UBIO, ubio);
	}

	public List<Userinfo5> findByUinterest(Object uinterest) {
		return findByProperty(UINTEREST, uinterest);
	}

	public List findAll() {
		log.debug("finding all Userinfo5 instances");
		try {
			String queryString = "from Userinfo5";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo5 merge(Userinfo5 detachedInstance) {
		log.debug("merging Userinfo5 instance");
		try {
			Userinfo5 result = (Userinfo5) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo5 instance) {
		log.debug("attaching dirty Userinfo5 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo5 instance) {
		log.debug("attaching clean Userinfo5 instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
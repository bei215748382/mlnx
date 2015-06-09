package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo1 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mlnxMS.core.Userinfo1
 * @author MyEclipse Persistence Tools
 */
public class Userinfo1DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Userinfo1DAO.class);
	// property constants
	public static final String UREALNAME = "urealname";
	public static final String USEX = "usex";
	public static final String URESIDENCE = "uresidence";
	public static final String UBIRTHDAY = "ubirthday";
	public static final String UBIRTHPLACE = "ubirthplace";
	public static final String UREMARK1 = "uremark1";
	public static final String UREMARK2 = "uremark2";

	public void save(Userinfo1 transientInstance) {
		log.debug("saving Userinfo1 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo1 persistentInstance) {
		log.debug("deleting Userinfo1 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo1 findById(java.lang.Integer id) {
		log.debug("getting Userinfo1 instance with id: " + id);
		try {
			Userinfo1 instance = (Userinfo1) getSession().get(
					"com.mlnxMS.core.Userinfo1", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo1> findByExample(Userinfo1 instance) {
		log.debug("finding Userinfo1 instance by example");
		try {
			List<Userinfo1> results = (List<Userinfo1>) getSession()
					.createCriteria("com.mlnxMS.core.Userinfo1")
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
		log.debug("finding Userinfo1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo1 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo1> findByUrealname(Object urealname) {
		return findByProperty(UREALNAME, urealname);
	}

	public List<Userinfo1> findByUsex(Object usex) {
		return findByProperty(USEX, usex);
	}

	public List<Userinfo1> findByUresidence(Object uresidence) {
		return findByProperty(URESIDENCE, uresidence);
	}

	public List<Userinfo1> findByUbirthday(Object ubirthday) {
		return findByProperty(UBIRTHDAY, ubirthday);
	}

	public List<Userinfo1> findByUbirthplace(Object ubirthplace) {
		return findByProperty(UBIRTHPLACE, ubirthplace);
	}

	public List<Userinfo1> findByUremark1(Object uremark1) {
		return findByProperty(UREMARK1, uremark1);
	}

	public List<Userinfo1> findByUremark2(Object uremark2) {
		return findByProperty(UREMARK2, uremark2);
	}

	public List findAll() {
		log.debug("finding all Userinfo1 instances");
		try {
			String queryString = "from Userinfo1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo1 merge(Userinfo1 detachedInstance) {
		log.debug("merging Userinfo1 instance");
		try {
			Userinfo1 result = (Userinfo1) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo1 instance) {
		log.debug("attaching dirty Userinfo1 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo1 instance) {
		log.debug("attaching clean Userinfo1 instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
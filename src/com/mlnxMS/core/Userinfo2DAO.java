package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo2 entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mlnxMS.core.Userinfo2
 * @author MyEclipse Persistence Tools
 */
public class Userinfo2DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Userinfo2DAO.class);
	// property constants
	public static final String UMOBILE = "umobile";
	public static final String UQQ = "uqq";
	public static final String UEMAIL = "uemail";
	public static final String UTELEPHONE = "utelephone";
	public static final String UMSN = "umsn";
	public static final String UTAOBAO = "utaobao";

	public void save(Userinfo2 transientInstance) {
		log.debug("saving Userinfo2 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo2 persistentInstance) {
		log.debug("deleting Userinfo2 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo2 findById(java.lang.Integer id) {
		log.debug("getting Userinfo2 instance with id: " + id);
		try {
			Userinfo2 instance = (Userinfo2) getSession().get(
					"com.mlnxMS.core.Userinfo2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo2> findByExample(Userinfo2 instance) {
		log.debug("finding Userinfo2 instance by example");
		try {
			List<Userinfo2> results = (List<Userinfo2>) getSession()
					.createCriteria("com.mlnxMS.core.Userinfo2")
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
		log.debug("finding Userinfo2 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo2 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo2> findByUmobile(Object umobile) {
		return findByProperty(UMOBILE, umobile);
	}

	public List<Userinfo2> findByUqq(Object uqq) {
		return findByProperty(UQQ, uqq);
	}

	public List<Userinfo2> findByUemail(Object uemail) {
		return findByProperty(UEMAIL, uemail);
	}

	public List<Userinfo2> findByUtelephone(Object utelephone) {
		return findByProperty(UTELEPHONE, utelephone);
	}

	public List<Userinfo2> findByUmsn(Object umsn) {
		return findByProperty(UMSN, umsn);
	}

	public List<Userinfo2> findByUtaobao(Object utaobao) {
		return findByProperty(UTAOBAO, utaobao);
	}

	public List findAll() {
		log.debug("finding all Userinfo2 instances");
		try {
			String queryString = "from Userinfo2";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo2 merge(Userinfo2 detachedInstance) {
		log.debug("merging Userinfo2 instance");
		try {
			Userinfo2 result = (Userinfo2) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo2 instance) {
		log.debug("attaching dirty Userinfo2 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo2 instance) {
		log.debug("attaching clean Userinfo2 instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
package com.mlnxMS.core;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Mail
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.mlnxMS.core.Mail
 * @author MyEclipse Persistence Tools
 */
public class MailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MailDAO.class);
	// property constants
	public static final String MAIL_TITLE = "mailTitle";
	public static final String MAIL_CONTENT = "mailContent";
	public static final String MSTATUS = "mstatus";

	public void save(Mail transientInstance) {
		log.debug("saving Mail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mail persistentInstance) {
		log.debug("deleting Mail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mail findById(java.lang.Integer id) {
		log.debug("getting Mail instance with id: " + id);
		try {
			Mail instance = (Mail) getSession().get("com.mlnxMS.core.Mail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Mail> findByExample(Mail instance) {
		log.debug("finding Mail instance by example");
		try {
			List<Mail> results = (List<Mail>) getSession()
					.createCriteria("com.mlnxMS.core.Mail")
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
		log.debug("finding Mail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Mail> findByMailTitle(Object mailTitle) {
		return findByProperty(MAIL_TITLE, mailTitle);
	}

	public List<Mail> findByMailContent(Object mailContent) {
		return findByProperty(MAIL_CONTENT, mailContent);
	}

	public List<Mail> findByMstatus(Object mstatus) {
		return findByProperty(MSTATUS, mstatus);
	}

	public List findAll() {
		log.debug("finding all Mail instances");
		try {
			String queryString = "from Mail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mail merge(Mail detachedInstance) {
		log.debug("merging Mail instance");
		try {
			Mail result = (Mail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mail instance) {
		log.debug("attaching dirty Mail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mail instance) {
		log.debug("attaching clean Mail instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
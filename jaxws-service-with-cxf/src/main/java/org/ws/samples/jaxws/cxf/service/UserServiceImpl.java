package org.ws.samples.jaxws.cxf.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.ws.samples.jaxws.cxf.model.User;

@Named
public class UserServiceImpl implements UserService {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public User getUserByLogin(final String login) {
		User user = null;
		try {
			Query q = em.createNamedQuery(User.FIND_BY_LOGIN);
			q.setParameter("login", login);
			user = (User) q.getSingleResult();
		} catch (NoResultException nre) {
			logger.warn("Il n'y a pas d'utiliseur correspondant au login {}.",
					login);
		}

		return user;
	}

	@Override
	public List<User> getUsers() {
		try {
			Query q = em.createNamedQuery(User.FIND_ALL);
			return q.getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public User save(User user) {
		if (user != null) {
			// try {
			em.persist(user);
			// } finally {
			// if (em != null) {
			// em.close();
			// }
			// }
		}
		return user;
	}

}

package org.ws.samples.jaxws.cxf.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.ws.samples.jaxws.cxf.model.User;

@Named
public class UserServiceImpl implements UserService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public User getUserByName(final String name) {
		User user = null;
		try {
			Query q = em.createNamedQuery(User.FIND_BY_NAME);
			q.setParameter("name", name);
			user = (User) q.getSingleResult();
		} catch (NoResultException nre) {
			try {
				user = new User();
				user.setName(name);
				em.persist(user);
			} finally {
				if (em != null) {
					em.close();
				}
			}
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

}

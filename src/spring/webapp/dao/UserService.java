package spring.webapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.webapp.dto.User;

@Service
public class UserService {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.clear();
			session.close();
		}
	}

	public User get(String email, String password) {
		Session session = sessionFactory.openSession();
		try {
			Query<User> query = session.createQuery("From User where email=:em and password=:pass", User.class);
			query.setParameter("em", email);
			query.setParameter("pass", password);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

}

package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Thought;
import com.app.utils.HibernateUtils;

public class ThoughtDaoImpl implements ThoughtDao {

	public void saveThought(Thought t) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(t);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public List<Thought> getThoughts() {
		List<Thought> ls = null;
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			ls = session.createQuery("from Thought" , Thought.class).getResultList();
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return ls;
	}

	public void delete(Long deleteId) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.delete(session.get(Thought.class, deleteId));
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	public void update(Thought t , Long id) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Thought thought = session.get(Thought.class, id);
			thought.setContent(t.getContent());
			thought.setTitle(t.getTitle());
			thought.setTimestamp(t.getTimestamp());
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}

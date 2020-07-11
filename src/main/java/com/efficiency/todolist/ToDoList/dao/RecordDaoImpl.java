package com.efficiency.todolist.ToDoList.dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efficiency.todolist.ToDoList.entity.Record;

@Repository
public class RecordDaoImpl implements RecordDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public RecordDaoImpl(EntityManager entityManager)
	{
		this.entityManager  = entityManager;
	}

	@Override
	public Record save(Record r) {
		
		Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(r);
        return r;
	}

	@Override
	public List<Record> getRecords(LocalDate date) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query thequery = session.createQuery("from Record where date=:rec_date");
		thequery.setParameter("rec_date",date);
		List<Record> rec = thequery.getResultList();
		
		return rec;
	}

	@Override
	public Record getRecord(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Record r = session.get(Record.class, id);
		
		return r;
	}

}

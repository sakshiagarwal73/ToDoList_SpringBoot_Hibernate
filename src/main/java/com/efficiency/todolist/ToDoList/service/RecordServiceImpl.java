package com.efficiency.todolist.ToDoList.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efficiency.todolist.ToDoList.dao.RecordDao;
import com.efficiency.todolist.ToDoList.entity.Record;

@Service
public class RecordServiceImpl implements RecordService {
	
	private RecordDao recordDao;
	
	@Autowired
	public RecordServiceImpl(RecordDao recordDao)
	{
		this.recordDao = recordDao;
	}

	@Override
	@Transactional
	public Record save(Record r) {
		
		recordDao.save(r);
        return r;
	}

	@Override
	@Transactional
	public List<Record> getRecords(LocalDate date) {
		
		return recordDao.getRecords(date);
	}

	@Override
	public Record getRecord(int id) {
		
		return recordDao.getRecord(id);
	}

}

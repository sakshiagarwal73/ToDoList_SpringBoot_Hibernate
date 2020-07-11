package com.efficiency.todolist.ToDoList.dao;

import java.time.LocalDate;
import java.util.List;

import com.efficiency.todolist.ToDoList.entity.Record;

public interface RecordDao {
	
	public Record save(Record r);
	
	public List<Record> getRecords(LocalDate date);
	
	public Record getRecord(int id);

}






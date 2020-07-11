package com.efficiency.todolist.ToDoList.service;


import java.time.LocalDate;
import java.util.List;

import com.efficiency.todolist.ToDoList.entity.Record;

public interface RecordService {
	
	
	
	public Record save(Record r);
	
	public List<Record> getRecords(LocalDate date);
	
	public Record getRecord(int id);

}

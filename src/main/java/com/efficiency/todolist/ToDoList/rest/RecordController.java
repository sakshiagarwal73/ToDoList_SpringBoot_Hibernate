package com.efficiency.todolist.ToDoList.rest;

import com.efficiency.todolist.ToDoList.entity.Record;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.efficiency.todolist.ToDoList.service.RecordService;

@RestController
@RequestMapping("/todo")
public class RecordController {
	
	private RecordService recordService;
	
	@Autowired
	public RecordController( RecordService recordService)
	{
		this.recordService = recordService;
	}
	
	@PostMapping("/addNew")
	public Record addNew(@RequestBody Record r)
	{
		r.setId(0);
		r.setDone(false);
		r.setDate(LocalDateTime.now().toLocalDate());
		recordService.save(r);
		return r;
	}
	
	@GetMapping("/record")
	public List<Record> getList(@RequestParam("start") 
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate)  
    {
		
		
		return recordService.getRecords(localDate);
	}
	
	@PutMapping("/check")
	public Record markAsDone(@RequestParam("rec_id") int id)
	{
		 Record r = recordService.getRecord(id);
		 if(r.getDate()==LocalDateTime.now().toLocalDate())
		 {
			 r.setDone(true);
			 recordService.save(r);
			 return r;
		 }
		 
		 return null;
	}
   
	

}

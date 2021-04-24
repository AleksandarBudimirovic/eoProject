package com.app.eoProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.dto.StudentDTO;
import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.model.Student;
import com.app.eoProject.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	StudentRepository repo;
	
	@Override
	public Student findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Student save(Student param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Student service...");
		repo.deleteById(id);
	}
	
	public List<ExamInstance> nepolozeniIspiti(Student student){
		List<ExamInstance> nepolozeniIspiti = new ArrayList<ExamInstance>();
		for(ExamInstance e : student.getExamInstance()) {
			if(e.getPointsScored() < 51) {
				nepolozeniIspiti.add(e);
			}
		}
		return nepolozeniIspiti;
	}
	
	public List<ExamInstance> prosliIspiti(Student student){
		Date date = new Date();
		List<ExamInstance> prosliIspiti = new ArrayList<ExamInstance>();
		for(ExamInstance e : student.getExamInstance()) {
			if(e.getEndDate().compareTo(date) < 0) {
				prosliIspiti.add(e);
			}
		}
		return prosliIspiti;
	}
	
	
	
}

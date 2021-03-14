package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.CourseSpecification;
import com.app.eoProject.model.Enrollment;
import com.app.eoProject.model.Student;
import com.app.eoProject.model.Teacher;



public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
	List<Enrollment> findByStudent(Student s);
	List<Enrollment> findByTeacher(Teacher s);
	List<Enrollment> findByCourseSpecification(CourseSpecification s);
	List<Enrollment> findByCourseInstance(CourseInstance s);

}

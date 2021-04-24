package com.app.eoProject.model;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_instance")
public class ExamInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_instance_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "start_date", unique = false, nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", unique = false, nullable = false)
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name="student", referencedColumnName="student_id", nullable=true)
	private Student student;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Student> studentList = new HashSet<Student>();
	
	@Column(name = "points_scored", unique = false, nullable = false)
	private Double pointsScored;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher", referencedColumnName = "teacher_id")
	private Teacher teacher;

	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToOne
	@JoinColumn(name="exam_specification", referencedColumnName="exam_specification_id", nullable=true)
	private ExamSpecification examSpecification;

	public ExamInstance(Long id, Date startDate, Date endDate, Student student, Set<Student> studentList,
			Double pointsScored, Teacher teacher, Set<Student> students, ExamSpecification examSpecification) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
		this.studentList = studentList;
		this.pointsScored = pointsScored;
		this.teacher = teacher;
		this.students = students;
		this.examSpecification = examSpecification;
	}

	public ExamInstance() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

	public Double getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(Double pointsScored) {
		this.pointsScored = pointsScored;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public ExamSpecification getExamSpecification() {
		return examSpecification;
	}

	public void setExamSpecification(ExamSpecification examSpecification) {
		this.examSpecification = examSpecification;
	}

	
	
	
	
}

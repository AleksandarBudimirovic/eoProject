package com.app.eoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eoProject.dto.UserDTO;
import com.app.eoProject.model.User;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.TeacherServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private TeacherServiceInterface teacherService;

	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(){
		
		List<User> users = userService.findAll();		
		
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		
		for(User u: users) {
			
			UserDTO objDTO = new UserDTO(u);
			
			usersDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
		
		User user = userService.findOne(id);
		
		if(user == null){
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		User user = new User();
		
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		user.setTeacher(teacherService.findOne(userDTO.getTeacher().getId()));
		user.setStudent(studentService.findOne(userDTO.getStudent().getId()));

		
			
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
		
		User user = userService.findOne(id); 
		
		if (user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		user.setTeacher(teacherService.findOne(userDTO.getTeacher().getId()));
		user.setStudent(studentService.findOne(userDTO.getStudent().getId()));
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		User user = userService.findOne(id);
		if (user != null){
			System.out.println("User nije null");
			
			System.out.println("Id je: " + id);
			
			userService.remove(id);
			System.out.println("removed");
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			System.out.println("Not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}

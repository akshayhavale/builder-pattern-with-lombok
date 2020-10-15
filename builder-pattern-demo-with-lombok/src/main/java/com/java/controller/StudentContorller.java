package com.java.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.StudentResponseDto;
import com.java.dto.StudentRquestDto;
import com.java.exception.WrongDataInsertionException;
import com.java.model.Student;
import com.java.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentContorller {

	@Autowired
	private StudentRepository repository;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/student")
	public StudentResponseDto createStudent(@RequestBody StudentRquestDto dto) throws WrongDataInsertionException {

		try {
			Student student = Student.builder().name(dto.getName()).active(dto.isActive()).build();
			student = repository.save(student);
			if (student == null) {
				throw new WrongDataInsertionException("WRONG DATA INPUT");
			}
			return StudentResponseDto.builder().id(student.getId()).name(student.getName()).active(student.isActive())
					.build();

		} catch (Exception e) {
			throw new WrongDataInsertionException(e.getMessage());
		}

	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value = "/student/{id}")
	public StudentResponseDto getStudent(@PathVariable(value = "id") int id) throws WrongDataInsertionException {

		try {
			Optional<Student> optional = repository.findById(id);
			Student student = null;
			if (!optional.isPresent()) {

				throw new WrongDataInsertionException("NOT_FOUND");
			} else {
				student = optional.get();
			}
			return StudentResponseDto.builder().id(student.getId()).name(student.getName()).active(student.isActive())
					.build();

		} catch (Exception e) {
			throw new WrongDataInsertionException(e.getMessage());
		}

	}

}

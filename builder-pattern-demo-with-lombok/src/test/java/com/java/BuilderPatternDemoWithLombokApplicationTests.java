package com.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.java.dto.StudentRquestDto;

@SpringBootTest
@RunWith(SpringRunner.class)
class BuilderPatternDemoWithLombokApplicationTests {

	@Test
	void insert() {
		String url = "http://localhost:8080/api/student";
		StudentRquestDto dto = new StudentRquestDto();
		dto.setActive(true);
		dto.setName("AKSHY");

//		StudentRquestDto dto = StudentRquestDto.builder().name("AKSHAY").active(true).build();
		HttpEntity<StudentRquestDto> request = new HttpEntity<StudentRquestDto>(dto);
		RestTemplate template = new RestTemplate();
		ResponseEntity<StudentRquestDto> response = template.postForEntity(url, request, StudentRquestDto.class);
		assertEquals(201, response.getStatusCodeValue());

	}

}

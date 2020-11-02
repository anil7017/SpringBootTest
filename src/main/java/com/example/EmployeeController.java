package com.example;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private static Map<String, Employee> employeeRepo = new HashMap<>();
	static {
		Employee emp1 = new Employee();
		emp1.setId("1");
		emp1.setName("Anil ");
		employeeRepo.put(emp1.getId(), emp1);

		Employee emp2 = new Employee();
		emp2.setId("2");
		emp2.setName("sunil");
		employeeRepo.put(emp2.getId(), emp2);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		employeeRepo.remove(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) {
		employeeRepo.remove(id);
		employee.setId(id);
		employeeRepo.put(id, employee);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Employee employee) {
		employeeRepo.put(employee.getId(), employee);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(employeeRepo.values(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
		
		Employee emp = employeeRepo.get(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}

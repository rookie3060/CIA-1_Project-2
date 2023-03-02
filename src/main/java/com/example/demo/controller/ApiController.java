package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.repository.ApiRepository;
import com.example.demo.service.ApiService;
@RestController
public class ApiController {
@Autowired
ApiRepository serviceRepository;
@Autowired
ApiService service;
@GetMapping("/")
List<Student> getList(){
return service.dispStudent();
}
@PostMapping("/")
public Student postStd(@RequestBody Student x) {
return service.createStudent(x);
}
@PutMapping("/{id}")
public String putStd(@PathVariable int id,@RequestBody Student x) {
return service.updateStudent(id,x);
}
@DeleteMapping("/{id}")
public String deleteStd(@PathVariable int id) {
return service.removeStudent(id);
}
}

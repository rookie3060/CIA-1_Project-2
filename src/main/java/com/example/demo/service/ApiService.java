package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.repository.ApiRepository;
@Service
public class ApiService {
@Autowired
ApiRepository repository;
public List<Student> dispStudent(){
return repository.findAll();
}
public Student createStudent(Student x) {
if(repository.existsById(x.getId())) {
return null;
}
return repository.save(x);
}
public String updateStudent(int id,Student x) {
if(repository.existsById(id)) {
Student temp=repository.getReferenceById(id);
temp.setId(id);
temp.setStudentName(x.getStudentName());
temp.setDepartmentName(x.getDepartmentName());
temp.setMobile(x.getMobile());
temp.setMailid(x.getMailid());
temp.setAddress(x.getAddress());
temp.setSection(x.getSection());
repository.save(temp);
return "updated";
}
return "Invalid ID";
}
public String removeStudent(int id) {
if(repository.existsById(id)) {
repository.deleteById(id);
return "Deleted";
}
return "Invalid ID";
}
}

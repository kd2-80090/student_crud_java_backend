package com.app.crud.service;

import org.springframework.stereotype.Service;
import com.app.crud.dto.StudentDto;
import com.app.crud.model.Student;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public StudentDto saveStudent(StudentDto student);

    public StudentDto updateStudent(Long id, StudentDto studentDto);

    public void deleteStudent(Long id);
}

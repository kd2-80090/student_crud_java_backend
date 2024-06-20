package com.app.crud.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.crud.repository.StudentRepository;
import com.app.crud.dto.StudentDto;
import com.app.crud.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ModelMapper mapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentDto saveStudent(StudentDto studentDto) {
    	Student student = mapper.map(studentDto,Student.class);
    	
        return mapper.map(studentRepository.save(student), StudentDto.class);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        if (studentRepository.existsById(id)) {
        	
        	Student student = mapper.map(studentDto, Student.class);
            student.setId(id);
            return mapper.map(studentRepository.save(student), StudentDto.class);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

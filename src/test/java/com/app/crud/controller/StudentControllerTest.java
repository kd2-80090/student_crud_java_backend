package com.app.crud.controller;

import com.app.crud.model.Student;
import com.app.crud.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("Nilesh Katkar");
        student.setAge(22);
        student.setCourse("Computer Science");
        student.setEmail("nilesh@gmail.com");

        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }
}

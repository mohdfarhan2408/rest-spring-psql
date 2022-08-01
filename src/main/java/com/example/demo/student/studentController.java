package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer

@RestController
@RequestMapping(path = "api/v1/students")
public class studentController {

    private final StudentService studentService;

    @Autowired
    public studentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updatestudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false) String email) {

        studentService.updateStudent(studentId, name, email);
    }

}

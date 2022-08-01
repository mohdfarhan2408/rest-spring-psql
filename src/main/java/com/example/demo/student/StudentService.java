package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


//Service/Business Layer
@Service
public class StudentService {

    //Dependencies
    private final StudentRepository studentRepository;

    @Autowired//Dependency injection, instead of using new Obj, we inject the dependencies (repo).
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());

        if (studentEmail.isPresent()) {
            throw new IllegalStateException("email is taken");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("student with id   " + studentId + " doesn't exist");
        }

        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("student with id   " + studentId + " doesn't exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            //If email is already taken
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()){
                throw new IllegalStateException("email is taken");
            }
            student.setEmail(email);
        }
    }
}



package com.luv2code.springoverview.rest;

import com.luv2code.springoverview.entity.Student;
import com.luv2code.springoverview.entity.StudentForPojoTest;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentForPojoTest> studentList;

    @PostConstruct
    public void loadData() {

        this.studentList = new ArrayList<>();

        this.studentList.add(new StudentForPojoTest("John", "Smith" ));
        this.studentList.add(new StudentForPojoTest("Bill", "Clinton" ));
        this.studentList.add(new StudentForPojoTest("Some", "Guy" ));
    }

    @GetMapping("/students")
    public List<StudentForPojoTest> getStudents() {
        return this.studentList;
    }

    @GetMapping("/student/{studentId}")
    public StudentForPojoTest getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= this.studentList.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return this.studentList.get(studentId);
    }
}

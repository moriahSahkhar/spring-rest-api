package org.restAPI.springbootrestapi.controller;

import org.restAPI.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {

        return new Student(1, "Moya", "Sahkhar");
    }

    @GetMapping("students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alex", "Sand"));
        students.add(new Student(2, "Moya", "Sahkhar"));

        return students;
    }

    @GetMapping("students/{id}/{fname}/{lname}")
    public Student studentPathVariable(@PathVariable("id") int id, @PathVariable("fname") String fname, @PathVariable("lname") String lname) {

        return new Student(id, fname, lname);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam(value = "id", required = true) int id,
                                          @RequestParam(value = "fname", required = true) String fname,
                                          @RequestParam(value = "lname", required = true) String lname){
        return new Student(id,fname,lname);
    }


}

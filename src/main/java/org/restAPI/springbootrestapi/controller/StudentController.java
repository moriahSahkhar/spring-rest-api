package org.restAPI.springbootrestapi.controller;

import org.restAPI.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
//        return new ResponseEntity<>(new Student(1, "Moya", "Sahkhar"), HttpStatus.OK);
        return ResponseEntity.ok().header("customHeader", "Moriah").body(new Student(1, "Moya", "Sahkhar"));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alex", "Sand"));
        students.add(new Student(2, "Moya", "Sahkhar"));

        return ResponseEntity.ok(students);
    }

    @GetMapping("{id}/{fname}/{lname}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id, @PathVariable("fname") String fname, @PathVariable("lname") String lname) {
        return ResponseEntity.ok(new Student(id, fname, lname));
    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "fname", required = true) String fname, @RequestParam(value = "lname", required = true) String lname) {
        return ResponseEntity.ok(new Student(id, fname, lname));
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        System.out.println("ID::"+student.getId());
        System.out.println("First Name::"+student.getFname());
        System.out.println("Last Name::"+student.getLname());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id){

        System.out.println("First Name::"+student.getFname());
        System.out.println("Last Name::"+student.getLname());

        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student, @PathVariable("id") int id){
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}

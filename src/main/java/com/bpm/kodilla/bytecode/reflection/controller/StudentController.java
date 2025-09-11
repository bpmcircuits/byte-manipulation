package com.bpm.kodilla.bytecode.reflection.controller;

import com.bpm.kodilla.bytecode.reflection.domain.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @PostMapping("/create/students")
    public Map<Integer, String> createStudents(
            @RequestParam(defaultValue = "20") int n,
            @RequestParam(defaultValue = "10") int z)
            throws NoSuchFieldException, IllegalAccessException {

        Map<Integer, String> result = new HashMap<>();
        Student[] students = new Student[n];

        for (Student student : students) {
            student = new Student(z);

            Field indexNumberField = Student.class.getDeclaredField("indexNumber");
            indexNumberField.setAccessible(true);
            String indexValue = (String) indexNumberField.get(student);
            result.put(System.identityHashCode(student), indexValue);
        }

        return result;
    }
}

package com.bpm.kodilla.bytecode.reflection.controller;

import com.bpm.kodilla.bytecode.reflection.domain.Student;
import com.bpm.kodilla.bytecode.reflection.validator.Range;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
public class StudentController {

    @PostMapping("/create/students")
    public Map<Integer, String> createStudents(@Valid
            @RequestParam(defaultValue = "20") @Range(min = 5, max = 30) int n,
            @RequestParam(defaultValue = "10") @Range(min = 7, max = 15) int z)
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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Map<String, String>> handleException(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        String[] errorArray = e.getMessage().split(":");
        errors.put(errorArray[0], errorArray[1]);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

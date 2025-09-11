package com.bpm.kodilla.bytecode.reflection.domain;

import com.bpm.kodilla.bytecode.reflection.RandomTextGenerator;

public class Student {

    private String indexNumber;

    public Student(int randomTextLength) {
        this.indexNumber = RandomTextGenerator.generateRandomText(randomTextLength);
    }
}

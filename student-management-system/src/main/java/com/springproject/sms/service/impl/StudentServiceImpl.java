package com.springproject.sms.service.impl;

import com.springproject.sms.dto.StudentDto;
import com.springproject.sms.entity.Student;
import com.springproject.sms.mapper.StudentMapper;
import com.springproject.sms.repository.StudentRepository;
import com.springproject.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(
                (student)-> StudentMapper.mapToStudentDto(student)
        )
                .collect(Collectors.toList());
        return studentDtos;
    }
}

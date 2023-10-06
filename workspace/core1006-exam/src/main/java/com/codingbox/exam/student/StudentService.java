package com.codingbox.exam.student;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

   private final StudentRepository studentRepository;

   public List<Student> boardList(){
      List<Student> list = studentRepository.findAll();
      Collections.reverse(list);
      return list;
   }

   public Student add(StudentForm sf){
      Student student = new Student();
      student.setName(sf.getName());
      student.setAge(sf.getAge());
      student.setSubject(sf.getSubject());
      student.setPhone(sf.getPhone());
      student.setAddr(sf.getAddr());
      return studentRepository.save(student);
   }

   public Student getById(Long id){
      return studentRepository.findById(id);
   }

   public Student editById(Long id, StudentForm sf){
      return studentRepository.update(id, sf);
   }
}

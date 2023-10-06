package com.codingbox.exam.student;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class StudentRepository {
   
   private static final Map<Long, Student> store = new LinkedHashMap<>();
   private static Long seq = 0L;

   public Student save(Student student){
      student.setId(++seq);
      store.put(student.getId(), student);
      return student;
   }

   public List<Student> findAll(){
      return new ArrayList<>(store.values());
   }

   public Student findById(Long id){
      return store.get(id);
   }

   public Student update(Long id, StudentForm sf){
      Student student = store.get(id);
      student.setName(sf.getName());
      student.setAge(sf.getAge());
      student.setSubject(sf.getSubject());
      student.setPhone(sf.getPhone());
      student.setAddr(sf.getAddr());
      return student;
   }

   @PostConstruct
   public void storeInit(){
      Student s1 = new Student();
      s1.setName("김철수");
      s1.setAge(22);
      s1.setSubject(2);
      s1.setPhone("0102345678");
      s1.setAddr("서울");

      Student s2 = new Student();
      s2.setName("김영희");
      s2.setAge(21);
      s2.setSubject(3);
      s2.setPhone("0104245678");
      s2.setAddr("경기");

      Student s3 = new Student();
      s3.setName("홍길동");
      s3.setAge(24);
      s3.setSubject(4);
      s3.setPhone("0107894653");
      s3.setAddr("인천");

      save(s1);
      save(s2);
      save(s3);
   }
}

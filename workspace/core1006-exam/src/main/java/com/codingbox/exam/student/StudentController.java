package com.codingbox.exam.student;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
   
   private final StudentService studentService;

   @GetMapping("/list")
   public String listPage(Model model){
      List<Student> studentList = studentService.boardList();
      model.addAttribute("stdList", studentList);
      return "student/students";
   }

   @GetMapping("/add")
   public String addPage(@ModelAttribute StudentForm studentForm){
      return "student/studentAddForm";
   }

   @PostMapping("/add")
   public String add(
         @Valid StudentForm studentForm, 
         BindingResult bResult, 
         RedirectAttributes rAttributes){
      if(bResult.hasErrors()){
         return "student/studentAddForm";
      }
      Student addStudent = studentService.add(studentForm);
      System.out.println("생성 : " + addStudent.toString());
      rAttributes.addAttribute("status", "add");
      return "redirect:/student/" + addStudent.getId();
   }

   @GetMapping("/{id}")
   public String getByid(
         @PathVariable Long id,
         Model model){
      Student student = studentService.getById(id);
      model.addAttribute("student", student);
      return "student/student";
   }

   @GetMapping("/edit/{id}")
   public String editPage(
      @PathVariable Long id,
      @ModelAttribute StudentForm studentForm){
      Student student = studentService.getById(id);
      studentForm.setId(student.getId());
      studentForm.setName(student.getName());
      studentForm.setAge(student.getAge());
      studentForm.setPhone(student.getPhone());
      studentForm.setSubject(student.getSubject());
      studentForm.setAddr(student.getAddr());
      return "student/studentEditForm";
   }

   @PostMapping("/edit/{id}")
   public String edit(
         @PathVariable Long id,
         @Valid StudentForm studentForm, 
         BindingResult bResult, 
         RedirectAttributes rAttributes){
      if(bResult.hasErrors()){
         return "student/studentEditForm";
      }
      Student editStudent = studentService.editById(id, studentForm);
      System.out.println("수정 : " + editStudent.toString());
      rAttributes.addAttribute("status", "edit");
      return "redirect:/student/" + editStudent.getId();
   }
}

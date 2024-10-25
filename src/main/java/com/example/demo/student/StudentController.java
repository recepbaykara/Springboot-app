package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public String registerNewStudent(@ModelAttribute Student student) {
        studentService.addNewStudent(student);
        return "redirect:/";
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students/view";
    }

    @PutMapping(path = "{studentId}")
    public String updateStudents(
        @PathVariable("studentId") Long studentId,
        @RequestBody Student studentDetails // Değişiklik burada
    ){
        studentService.updateStudents(studentId, studentDetails.getName(), studentDetails.getEmail());
        
        return "redirect:/students/view"; 

    }


    @GetMapping("/")
    public String showStudentForm() {
        return "index";
    }

    @GetMapping("/view")
    public String viewStudents(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "view";
    }
}

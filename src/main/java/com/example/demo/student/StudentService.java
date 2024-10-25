package com.example.demo.student;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


    public List<Student> getStudents() {
		return studentRepository.findAll();
	}


    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentOptional.isPresent()){
			throw new IllegalStateException("email has taken");
		}

		studentRepository.save(student);

    }


    public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);

		if (!exists){
			throw new IllegalStateException("studentd with id" + studentId + "does not exists");
		}

		studentRepository.deleteById(studentId);
    }

	@Transactional
		public void updateStudents(Long studentId, String name, String email) {
			Student student = studentRepository.findById(studentId)
												.orElseThrow(() -> new IllegalStateException(
													"student with id " + studentId + " does not exist"));
			
			if (name != null && name.length() > 0 && !name.equals(student.getName())) {
				student.setName(name);
			}

			if (email != null && email.length() > 0 && !email.equals(student.getEmail())) {
				Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
				
				if (studentOptional.isPresent()) {
					throw new IllegalStateException("email taken");
				}
				student.setEmail(email);
			}
	}

}

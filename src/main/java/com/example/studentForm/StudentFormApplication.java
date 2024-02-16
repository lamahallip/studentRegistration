package com.example.studentForm;

import com.example.studentForm.model.Student;
import com.example.studentForm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentFormApplication  implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;


	public static void main(String[] args) {
		SpringApplication.run(StudentFormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(1L, "Allip", "Lamah", "alliplamah58@gmail.com", "Université Francaise de Guinée");
		studentRepository.save(student1);
		Student student2 = new Student(2L, "Jeremy", "Chérif", "jeremycherif@gmail.com", "ISIM");
		studentRepository.save(student2);
		Student student3 = new Student(3L, "Ernest", "Lamah", "ernestlamah@gmail.com", "ISACEG");
		studentRepository.save(student3);
		Student student4 = new Student(4L, "Oumar", "Condé", "oumouconde@gmail.com", "Last Kingdom");
		studentRepository.save(student4);

	}
}

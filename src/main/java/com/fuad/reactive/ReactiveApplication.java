package com.fuad.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fuad.reactive.student.Student;
import com.fuad.reactive.student.StudentService;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(StudentService service){
		return args -> {
			
			for(int i = 0; i <= 100; i++){
				service.save(
					Student.builder()
					.firstname("Mohammad" + i)
					.lastname("Fuad" + i)
					.age(i)
					.build()
				).subscribe();
			}
		};
	}
}

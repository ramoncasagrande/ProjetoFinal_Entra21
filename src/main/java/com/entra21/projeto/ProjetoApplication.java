package com.entra21.projeto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entra21.projeto.model.Course;
import com.entra21.projeto.model.Users;
import com.entra21.projeto.repositories.CourseRepository;
import com.entra21.projeto.repositories.UserRepository;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(UserRepository userRepository){
		return args -> {

			Users user1 = new Users();
			user1.setName("Ramon Casagrande");
			user1.setEmail("ramon@email.com");
			user1.setPassword("123456");
			user1.setRole("ALUNO");

			Users user2 = new Users();
			user2.setName("Radamés Rodrigues Neto");
			user2.setEmail("radames@email.com");
			user2.setPassword("abcdef");
			user2.setRole("ALUNO");

			Users user3 = new Users();
			user3.setName("Silvia Lemes");
			user3.setEmail("silvia@email.com");
			user3.setPassword("sil123");
			user3.setRole("ALUNO");

			Users user4 = new Users();
			user4.setName("Yuri Pokamaja");
			user4.setEmail("yuri@email.com");
			user4.setPassword("yuri321");
			user4.setRole("ALUNO");

			Users user5 = new Users();
			user5.setName("Bruno");
			user5.setEmail("bruno@email.com");
			user5.setPassword("admin");
			user5.setRole("ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);
		};
	}

	@Bean
	CommandLineRunner courseDataBase(CourseRepository courseRepository){
		return args -> {

			Course course1 = new Course();
			course1.setTitle("JavaScript Aula 01");
			course1.setDescription("Você sabe para que serve a linguagem JavaScript / ECMAScript? Sabe a diferença entre um cliente e um servidor para a Internet? Sabe para que servem as tecnologias HTML5, CSS3 e JavaScript?");
			course1.setLinkVideo("https://www.youtube.com/watch?v=Ptbk2af68e8&list=PLHz_AreHm4dlsK3Nr9GVvXCbpQyHQl1o1&index=5");

			Course course2 = new Course();
			course2.setTitle("JavaScript Aula 02");
			course2.setDescription("Você sabe para que serve a linguagem JavaScript / ECMAScript? Sabe a diferença entre um cliente e um servidor para a Internet? Sabe para que servem as tecnologias HTML5, CSS3 e JavaScript?");
			course2.setLinkVideo("https://www.youtube.com/watch?v=rUTKomc2gG8&list=PLHz_AreHm4dlsK3Nr9GVvXCbpQyHQl1o1&index=5");

			courseRepository.save(course1);
			courseRepository.save(course2);

		};
	}

}

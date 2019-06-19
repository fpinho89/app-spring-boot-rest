package com.app;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.model.Autor;
import com.app.model.Livro;
import com.app.repository.LivroRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
    CommandLineRunner init(LivroRepository repository) {
        return args -> {
            Stream.of("Livro 1", "Livro 2", "Livro 3").forEach(titulo -> {
                
            	Livro livro = new Livro();
            	livro.setTitulo(titulo);
            	livro.setDescricao("desc - "+titulo);
            	livro.setIsbn(UUID.randomUUID().toString());
            	livro.setAutor(new Autor("Autor "+UUID.randomUUID().toString()));
                repository.save(livro);
            });
//            userRepository.findAll().OforEach(System.out::println);
        };
    }
	
}

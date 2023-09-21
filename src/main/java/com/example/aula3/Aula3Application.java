package com.example.aula3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aula3.models.CategoriaCurso;
import com.example.aula3.models.CategoriaProduto;
import com.example.aula3.models.Curso;
import com.example.aula3.models.Produto;
import com.example.aula3.repository.CategoriaCursoRepository;
import com.example.aula3.repository.CursoRepository;

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository, 
	@Autowired CategoriaCursoRepository categoriaCursoRepository) {
		return args -> {
			cursoRepository.save(
					new Curso((long) 0, "teste1", 2000));

					
			cursoRepository.save(
					new Curso((long) 0, "teste2", 2050));


			List<Curso> listaCursos = cursoRepository.findAll();
			listaCursos.forEach(System.out::println);

			System.out.println("** Exemplo obter por nome **");
			listaCursos = cursoRepository.findByNomeLike("%2");
			listaCursos.forEach(System.out::println);

			// System.out.println("Inserir Categoria");
			// CategoriaProduto c1 = new CategoriaProduto((long) 0 , "Nivel 1", "Primeiro");
			// categoriacursoRepository.inserir(c1);

			// System.out.println("Exemplo Atualiza");
			// listaProdutos.get(0).setCategoriaProduto(c1);
			// cursoRepository.inserir(listaProdutos.get(0));

			// System.out.println("Exemplo Delete");
			// cursoRepository.excluirPorId(1);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}

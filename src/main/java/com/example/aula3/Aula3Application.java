package com.example.aula3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aula3.models.CategoriaProduto;
import com.example.aula3.models.Produto;
import com.example.aula3.repository.CategoriaProdutoRepository;
import com.example.aula3.repository.CategoriaRepository;
import com.example.aula3.repository.ProdutoRepository;

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository, 
	@Autowired CategoriaRepository categoriaRepository) {
		return args -> {
			produtoRepository.save(
					new Produto((long) 0, "prod1", 2000));

					
			produtoRepository.save(
					new Produto((long) 0, "prod2", 2000));


			List<Produto> listaProdutos = produtoRepository.findAll();
			listaProdutos.forEach(System.out::println);

			System.out.println("Exemplo obter por nome");
			listaProdutos = produtoRepository.findByProd_nome("%2");
			listaProdutos.forEach(System.out::println);

			System.out.println("Inserir Categoria");
			CategoriaProduto c1 = new CategoriaProduto((long) 0 , "Nivel 1", "Primeiro");
			categoriaRepository.save(c1);

			System.out.println("Exemplo Atualiza");
			listaProdutos.get(0).setCategoriaProduto(c1);
			produtoRepository.save(listaProdutos.get(0));

			// System.out.println("Exemplo Delete");
			// produtoRepository.delete(2);



		List<CategoriaProduto> categs = categoriaRepository.findAll();
		for(CategoriaProduto ca: categs){
			System.out.println(ca.getId() + " - " + ca.getCat_nome());
		}

		CategoriaProduto pp = categoriaRepository.findCategoriaProdutoFetchProduto((long) 1);
		System.out.println(pp.getCat_nome());

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}

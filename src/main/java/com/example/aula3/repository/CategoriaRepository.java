package com.example.aula3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.aula3.models.Categoria;
import com.example.aula3.models.CategoriaProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public interface CategoriaRepository extends JpaRepository<CategoriaProduto, Long>{
   
    List<CategoriaProduto> findByNomeStartingWith(String preffix);

    @Query("SELECT pp from CategoriaProduto pp left join fetch pp.produto p WHERE pp.id = :id")
    CategoriaProduto findCategoriaProdutoFetchProduto(@Param("id") Long id);
    
}

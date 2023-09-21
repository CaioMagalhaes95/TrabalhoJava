package com.example.aula3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

import com.example.aula3.models.*;

@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer> {
    // @Autowired
    // private EntityManager entityManager;

    // @Transactional
    // public CategoriaCurso inserir(CategoriaCurso categoriaCurso) {
    // entityManager.persist(categoriaCurso);
    // return categoriaCurso;
    // }

    // public List< CategoriaCurso > obterTodos() {
    // return entityManager.createQuery("from CategoriaCurso", CategoriaCurso.class).getResultList();
    // }
}

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}

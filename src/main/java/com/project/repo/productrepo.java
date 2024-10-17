package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.product;

public interface productrepo extends JpaRepository<product, Integer> {

}

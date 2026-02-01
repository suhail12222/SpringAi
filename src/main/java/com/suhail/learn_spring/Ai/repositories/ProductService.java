package com.suhail.learn_spring.Ai.repositories;

import com.suhail.learn_spring.Ai.entities.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService extends JpaRepository<Products,Long> {
List<Products>findBy(Sort sortBy);
List<Products>findByLastName(String lastName, Pageable pageable);
List<Products>findAll(Pageable pageable,String tittle);
}

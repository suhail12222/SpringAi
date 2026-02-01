package com.suhail.learn_spring.Ai.controller;

import com.suhail.learn_spring.Ai.entities.Products;
import com.suhail.learn_spring.Ai.repositories.ProductService;
import org.hibernate.query.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
private final ProductService productService;
private final int PAGE_SIZE=5;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products>getAllProductsSortBy(@RequestParam(defaultValue = "id")String sortBy){
        return productService.findBy(Sort.by(sortBy));//it will sort by acc

    }
    @GetMapping
    public List<Products> getProductsInDesc(@RequestParam(defaultValue = "id")String sortBy){
        return productService.findBy(Sort.by(Sort.Direction.DESC,sortBy));
    }
    @GetMapping
    public List<Products>getAllProductsOnMulipleSorts(@RequestParam(defaultValue = "id")String sortBy){
        return productService.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price","quality"));//"anything means multiple sorting "
    }
    @GetMapping
    public List<Products> getAllProductsOnMultiples(@RequestParam(defaultValue = "id")String sortBy){
        return productService.findBy(Sort.by(Sort.Order.desc("name")

        ,
                Sort.Order.asc("tittle")
        ));
    }
    @GetMapping
    public Page<Products> getProductsInPAge(@RequestParam(defaultValue = "id")
                                                String sortBy, @RequestParam(defaultValue = "1") Integer pageNumber){
     Pageable pageable=PageRequest.of(pageNumber,PAGE_SIZE);
     return productService.findAll(pageable);



    }
//    Pageable pageable= PageRequest.of(pageNumber,size,Sort.by("lastName").ascending());
}

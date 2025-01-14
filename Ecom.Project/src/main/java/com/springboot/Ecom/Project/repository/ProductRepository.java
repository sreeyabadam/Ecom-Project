package com.springboot.Ecom.Project.repository;

import com.springboot.Ecom.Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("select p from Product p where"+
    " lower(p.name) Like Lower(concat('%', :keyword,'%' ))OR "+
    " lower(p.brand) like lower(concat('%', :keyword,'%'))OR "+
    " lower(p.description) like lower(concat('%', :keyword,'%'))OR "+
    " lower(p.category) like lower(concat('%', :keyword,'%'))")
    List<Product> searchProducts(String keyword);
}

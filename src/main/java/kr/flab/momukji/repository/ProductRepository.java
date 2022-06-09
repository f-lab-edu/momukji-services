package kr.flab.momukji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.flab.momukji.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

package kr.flab.momukji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.flab.momukji.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}

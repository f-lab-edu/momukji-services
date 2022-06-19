package kr.flab.momukji.repository;

import kr.flab.momukji.entity.Order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
 
    Optional<Order> findById(Long id);
}

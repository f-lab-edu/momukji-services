package kr.flab.momukji.repository;

import kr.flab.momukji.entity.Order;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph(attributePaths = {"product_id"})
    Optional<Order> findById(Long id);
}

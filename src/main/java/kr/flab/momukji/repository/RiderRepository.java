package kr.flab.momukji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.flab.momukji.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    
}

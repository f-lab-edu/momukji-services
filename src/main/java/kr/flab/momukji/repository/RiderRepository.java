package kr.flab.momukji.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.flab.momukji.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider,Long>{
    
}

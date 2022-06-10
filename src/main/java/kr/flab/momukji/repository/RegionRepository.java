package kr.flab.momukji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.flab.momukji.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    
}
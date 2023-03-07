package com.example.msaservicecoffeestatus.springboot.repository;


import com.example.msaservicecoffeestatus.springboot.jvo.StatusJVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusJPARepository extends JpaRepository<StatusJVO, String> {
}

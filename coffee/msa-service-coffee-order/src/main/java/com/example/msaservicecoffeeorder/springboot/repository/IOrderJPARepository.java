package com.example.msaservicecoffeeorder.springboot.repository;

import com.example.msaservicecoffeeorder.springboot.jvo.OrderJVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderJPARepository extends JpaRepository<OrderJVO, String> {
}

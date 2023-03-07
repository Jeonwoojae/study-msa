package com.example.msaservicecoffeemember.springboot.repository;


import com.example.msaservicecoffeemember.springboot.jvo.UserJVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJPARepository extends JpaRepository<UserJVO, String> {
}

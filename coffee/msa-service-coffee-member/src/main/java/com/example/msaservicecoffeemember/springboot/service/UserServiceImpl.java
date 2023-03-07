package com.example.msaservicecoffeemember.springboot.service;


import com.example.msaservicecoffeemember.domain.repository.IUserRepository;
import com.example.msaservicecoffeemember.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends UserService {

    public UserServiceImpl(IUserRepository iUserRepository) {

        super(iUserRepository);
    }
}
package com.example.msaservicecoffeestatus.springboot.service;


import com.example.msaservicecoffeestatus.domain.repository.IStatusRepository;
import com.example.msaservicecoffeestatus.domain.service.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends StatusService {

    public StatusServiceImpl(IStatusRepository iStatusRepository) {

        super(iStatusRepository);
    }
}
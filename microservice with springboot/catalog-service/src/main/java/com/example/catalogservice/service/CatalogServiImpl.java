package com.example.catalogservice.service;

import com.example.catalogservice.repository.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class CatalogServiImpl implements CatalogService{
    CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiImpl(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<CatalogEntity> getAllCatalog() {
        return catalogRepository.findAll();
    }
}

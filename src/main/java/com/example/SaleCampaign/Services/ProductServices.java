package com.example.SaleCampaign.Services;


import com.example.SaleCampaign.Model.Product;
import com.example.SaleCampaign.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> addProducts(List<Product>products){
      return new ResponseEntity<>(productRepository.saveAll(products), HttpStatus.OK);
    }
    public Page<Product> getPagination(int pageNo,int size){
        Pageable pageable= PageRequest.of(pageNo,size);
        return productRepository.findAll(pageable);
    }
    public List<Product> getAllProductSortByProductId(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,"pId"));
    }
    public Page<Product> getPaginationAndSortByProductId(int pageNo,int size){
        Pageable pageable=PageRequest.of(pageNo,size).withSort(Sort.by(Sort.Direction.ASC,"pId"));
        return productRepository.findAll(pageable);
    }
}

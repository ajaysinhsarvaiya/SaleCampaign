package com.example.SaleCampaign.Controller;


import com.example.SaleCampaign.Model.Product;
import com.example.SaleCampaign.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amazon")
public class ProductController {

    @Autowired
    private ProductServices productServices;
    @PostMapping("/addproduct")
    public ResponseEntity<?> addProducts(@RequestBody List<Product> product)
    {
        return new ResponseEntity<>(productServices.addProducts(product),HttpStatus.OK);
    }
        @GetMapping("/pagination")
        public ResponseEntity<?> pagination(@RequestParam int pageNo, @RequestParam int size){
        return new ResponseEntity<>(productServices.getPagination(pageNo,size), HttpStatus.OK);
    }
    @GetMapping("/getAllProductsSortByProductId")
    public ResponseEntity<?> getAllProductsSortByProductId(){
        return new ResponseEntity<>(productServices.getAllProductSortByProductId(),HttpStatus.OK);
    }
    @GetMapping("/getPaginationAndSortByProductId")
    public ResponseEntity<?>getPaginationAndSortByProductId(@RequestParam int pageNo,@RequestParam int size){
        return new ResponseEntity<>(productServices.getPaginationAndSortByProductId(pageNo,size),HttpStatus.OK);
    }

}

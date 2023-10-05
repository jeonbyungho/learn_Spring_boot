package com.training.exam.product;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

   private final ProductRepository productRepository;

   public List<Product> productList(){
      List<Product> list = productRepository.findAll();
      Collections.reverse(list);
      return list;
   }

   public Product getProductById(Long id){
      return productRepository.findId(id);
   }

   public Product editProduct(Long id, Product product){
      return productRepository.update(id, product);
   }

   public Product addProduct(Product product){
      return productRepository.save(product);
   }
}

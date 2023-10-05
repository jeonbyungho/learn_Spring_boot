package com.training.exam.product;

import java.util.List;

public interface ProductRepository {
   
   public Product save(Product item);
   public Product findId(Long id);
   public List<Product> findAll();
   public Product update(Long id, Product updateItem);
}

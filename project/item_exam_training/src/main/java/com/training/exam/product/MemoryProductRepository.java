package com.training.exam.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MemoryProductRepository implements ProductRepository{
   
   private static final Map<Long, Product> store = new LinkedHashMap<>();
   private static long sequence = 0L;

   @Override
   public List<Product> findAll() {
      return new ArrayList<>(store.values());
   }

   @Override
   public Product findId(Long id) {
      return store.get(id);
   }

   @Override
   public Product save(Product product) {
      product.setId(++sequence);
      return store.put(product.getId(), product);
   }

   @Override
   public Product update(Long id, Product updateProduct) {
      Product product = findId(id);
      product.setName(updateProduct.getName());
      product.setPrice(updateProduct.getPrice());
      product.setQuantity(updateProduct.getQuantity());
      return product;
   }
   
   @PostConstruct
   public void storeInit(){
      Product product1 = new Product();
      product1.setName("사과");
      product1.setPrice(9500);
      product1.setQuantity(100);

      Product product2 = new Product();
      product2.setName("배");
      product2.setPrice(12250);
      product2.setQuantity(82);

      Product product3 = new Product();
      product3.setName("참외");
      product3.setPrice(7000);
      product3.setQuantity(70);

      save(product1);
      save(product2);
      save(product3);
   }
}

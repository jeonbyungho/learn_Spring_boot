package com.ex.mvcweb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.mvcweb.entity.Item;
import com.ex.mvcweb.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
   
   private final ItemRepository itemRepository;

   @Transactional
   public Long add(Item item) {
      itemRepository.save(item);
      log.info("━━add " + item.toString());
      return item.getId();
   }

   public List<Item> findAll(int page) {
      return itemRepository.findAll(page - 1);
   }

   public Item findOne(long id){
      return itemRepository.finById(id);
   }

   @Transactional
   public Item edit(long itemId, Item item) {
      Item findItem = itemRepository.finById(itemId);
      findItem.setName(item.getName());
      findItem.setPrice(item.getPrice());
      findItem.setStockQuantity(item.getStockQuantity());
      /*
       * 영속성 컨텍스 영역으로 들어온 후, 영속성 컨텍스트에 변화가 일어나게 되고, 변화가 일어나는 것을 JPA가 감지한다.
       * 영속성 컨텍스트에서 flush를 호출.
       * flush는 변화가 생긴 부분을 감지한 후, update쿼리를 작성한다. -> 변경 감지에 의한 데이터를 update하는 방법.
       */
      return findItem;
   }

   @Transactional
   public Item edit(Long itemId, String name, int price, int stockQuantity) {
      Item findItem = itemRepository.finById(itemId);
      findItem.setName(name);
      findItem.setPrice(price);
      findItem.setStockQuantity(stockQuantity);
      // Update 되는 데이터가 많으면 파리미터를 나열하는 대신, 서비스 계층에서 업데이트만을 위한 DTO을 따로 만들어도 된다.
      return findItem;
   }

}

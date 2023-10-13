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
}

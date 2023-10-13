package com.ex.mvcweb.service;

import org.springframework.stereotype.Service;

import com.ex.mvcweb.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
   
   private final ItemRepository itemRepository;
}

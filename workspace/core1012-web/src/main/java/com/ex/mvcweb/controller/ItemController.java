package com.ex.mvcweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.mvcweb.dto.ItemFrom;
import com.ex.mvcweb.entity.Item;
import com.ex.mvcweb.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

   private final ItemService itemService;

   @GetMapping("/new")
   public String createItem(@ModelAttribute ItemFrom itemFrom){
      return "items/createItemForm";
   }

   @PostMapping("/new")
   public String createItem(@Valid ItemFrom itemFrom, BindingResult bindingResult){
      if(bindingResult.hasErrors()){
         return "items/createItemForm";
      }
      Item item = new Item();
      item.setName(itemFrom.getName());
      item.setPrice(itemFrom.getPrice());
      item.setStockQuantity(itemFrom.getStockQuantity());
      itemService.add(item);
      return "redirect:/";
   }

   @GetMapping
   public String memberList(
         @RequestParam(defaultValue = "1", required = false) Integer page, 
         Model model){
      log.info("━━page : " + page);
      List<Item> items = itemService.findAll(page);
      model.addAttribute("items", items);
      model.addAttribute("currentPage", page);
      log.info("━━size : " + items.size());
      return "items/itemList";
   }
}

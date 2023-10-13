package com.ex.mvcweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.mvcweb.dto.ItemFrom;
import com.ex.mvcweb.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

   private final ItemService itemService;

   @GetMapping("/new")
   public String createItem(@ModelAttribute ItemFrom itemFrom){
      return "createItemForm";
   }

   @PostMapping("/new")
   public String createItem(@Valid ItemFrom itemFrom, BindingResult bindingResult){
      if(bindingResult.hasErrors()){
         return "createItemForm";
      }
      return "createItemForm";
   }
}

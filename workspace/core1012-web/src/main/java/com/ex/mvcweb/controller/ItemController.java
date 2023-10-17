package com.ex.mvcweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.mvcweb.dto.ItemForm;
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
   public String createItem(@ModelAttribute ItemForm itemFrom){
      return "items/createItemForm";
   }

   @PostMapping("/new")
   public String createItem(@Valid ItemForm itemForm, BindingResult bindingResult){
      if(bindingResult.hasErrors()){
         return "items/createItemForm";
      }
      Item item = new Item();
      item.setName(itemForm.getName());
      item.setPrice(itemForm.getPrice());
      item.setStockQuantity(itemForm.getStockQuantity());
      itemService.add(item);
      return "redirect:/";
   }

   @GetMapping
   public String itemList(
         @RequestParam(defaultValue = "1", required = false) Integer page, 
         Model model){
      log.info("━━page : " + page);
      List<Item> items = itemService.findAll(page);
      model.addAttribute("items", items);
      model.addAttribute("currentPage", page);
      log.info("━━size : " + items.size());
      return "items/itemList";
   }

   @GetMapping("/{itemNo}/edit")
   public String editItem(@PathVariable Long itemNo, Model model){
      Item item = itemService.findOne(itemNo);
      log.info("item : " + item.toString());
      ItemForm itemForm = new ItemForm();
      itemForm.setId(item.getId());
      itemForm.setName(item.getName());
      itemForm.setPrice(item.getPrice());
      itemForm.setStockQuantity(item.getStockQuantity());
      model.addAttribute("itemForm", itemForm);
      return "items/updateItemForm";
   }

   //@PostMapping("/{itemNo}/edit")
   public String editItem1(@PathVariable Long itemNo,
         @Valid ItemForm itemFrom, BindingResult bindingResult,
         Model model){
      log.info("Post From : " + itemFrom.toString());

      Item item = new Item();
      item.setId(itemNo);
      item.setName(itemFrom.getName());
      item.setPrice(itemFrom.getPrice());
      item.setStockQuantity(itemFrom.getStockQuantity());
      itemService.edit(itemNo, item);
      return "redirect:/items/" + itemNo + "/edit";
   }

   @PostMapping("/{itemNo}/edit")
   public String editItem2(@PathVariable Long itemNo,
         @Valid ItemForm itemFrom, BindingResult bindingResult,
         Model model){
      log.info("Post From : " + itemFrom.toString());
      itemService.edit(itemNo, itemFrom.getName(), itemFrom.getPrice(), itemFrom.getStockQuantity());
      
      return "redirect:/items/" + itemNo + "/edit";
   }
}

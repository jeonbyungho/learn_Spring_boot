package com.ex.mvcweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.mvcweb.dto.OrderFrom;
import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.service.ItemService;
import com.ex.mvcweb.service.MemberService;
import com.ex.mvcweb.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
   private final OrderService orderService;
   private final MemberService memberService;
   private final ItemService itemService;

   @GetMapping
   public String order(@ModelAttribute OrderFrom orderFrom, Model model){
      model.addAttribute("members", memberService.findAll());
      model.addAttribute("items", itemService.findAll());
      return "/order/orderForm";
   }
}

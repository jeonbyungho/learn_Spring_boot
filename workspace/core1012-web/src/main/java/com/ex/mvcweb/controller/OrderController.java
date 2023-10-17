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

import com.ex.mvcweb.dto.OrderForm;
import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.repository.OrderSearch;
import com.ex.mvcweb.service.ItemService;
import com.ex.mvcweb.service.MemberService;
import com.ex.mvcweb.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
   private final OrderService orderService;
   private final MemberService memberService;
   private final ItemService itemService;

   @GetMapping
   public String order(@ModelAttribute OrderForm orderForm, Model model){
      model.addAttribute("members", memberService.findAll());
      model.addAttribute("items", itemService.findAll());
      return "/order/orderForm";
   }

   @PostMapping
   public String order(@Valid OrderForm orderForm, BindingResult bindingResult){
      log.info("오더 : " + orderForm.toString());
      if(bindingResult.hasErrors()){
         return "/order/orderForm";
      }
      orderService.add(orderForm);
      return "redirect:/order/list";
   }

   @GetMapping("/list")
   public String orderList(@ModelAttribute OrderSearch orderSearch, Model model){
      List<Order> orders = orderService.findAll(orderSearch);
      model.addAttribute("orders", orders);
      return "/order/orderList";
   }

   @PostMapping("/{orderId}/cancel")
   public String cancel(@PathVariable Long orderId){
      orderService.cancelOrder(orderId);
      return "redirect:/order/list";
   }
}

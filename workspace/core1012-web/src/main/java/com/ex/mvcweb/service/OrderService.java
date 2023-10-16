package com.ex.mvcweb.service;

import org.springframework.stereotype.Service;

import com.ex.mvcweb.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
   private final OrderRepository orderRepository;
}

package com.web.item.domain.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.item.domain.web.dto.Item;
import com.web.item.domain.web.repository.ItemRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

/**
 * lombok.@RequiredArgsConstructor : final 멤버 변수만 사용해서 생성자를 자동으로 만들어준다.
 */
@Controller
@RequestMapping("basic/items")
@RequiredArgsConstructor
public class BasicItemController {
	
	private final ItemRepository itemRepository;
	
// 생성자의 파라미터가 한 개뿐이라면 자동으로 스프링이 생성자에게 @Autowired로 의존관계를 주입해준다.
//	public BasicItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
	
	@GetMapping
	public String items(Model model) {
		List<Item> itemsList = itemRepository.findAll();
		model.addAttribute("itemsList", itemsList);
		return "basic/items";
	}
	
	/** 초기화 메서드 : 서버가 실행되는 시점에 호출되는 메서드이다.*/
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("TestA", 10000, 10));
		itemRepository.save(new Item("TestA", 20000, 15));
		itemRepository.save(new Item("TestB", 30000, 20));
		itemRepository.save(new Item("TestC", 40000, 25));
		itemRepository.save(new Item("TestD", 50000, 30));
		itemRepository.save(new Item("TestF", 60000, 35));
		System.out.println("Call BasicItemController.Init() ");
	}
	
	/** 종료 메서드 : 서버가 종료되는 시점에 호출되는 메서드이다.*/
	@PreDestroy
	public void destory() {
		System.out.println("Call BasicItemController.destory()");
	}
	
}

package com.web.item.domain.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		itemRepository.save(new Item("사과", 10000, 10));
		itemRepository.save(new Item("바나나", 20000, 15));
		itemRepository.save(new Item("복숭아", 30000, 20));
		itemRepository.save(new Item("키위", 40000, 25));
		itemRepository.save(new Item("참외", 50000, 30));
		itemRepository.save(new Item("수박", 60000, 35));
		System.out.println("Call BasicItemController.Init() ");
	}
	
	/** 종료 메서드 : 서버가 종료되는 시점에 호출되는 메서드이다.*/
	@PreDestroy
	public void destory() {
		System.out.println("Call BasicItemController.destory()");
	}
	
	@GetMapping("/{itemId}")
	public String getItem(
			@PathVariable("itemId") Long itemId,
			Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		System.out.println(item.toString());
		return "basic/item";
	}
	
	/**상품 추가 페이지 이동*/
	@GetMapping("/add")
	public String getItemAddForm() {
		return "basic/addForm";
	}
	
	/**상품 추가*/
	@PostMapping("/add")
	public String saveItem(Item itemData) {
		System.out.println(itemData.toString());
		itemRepository.save(itemData);
		return "redirect:/basic/items";
	}
	
	/**상품 수정 페이지 이동*/
	@GetMapping("/edit/{itemId}")
	public String getItemEditForm(
			@PathVariable("itemId") Long itemId,
			Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		System.out.println(item.toString());
		return "basic/editForm";
	}
	
	/**상품 수정*/
	@PostMapping("/edit/{itemId}")
	public String updatItem(
			@PathVariable("itemId") Long itemId,
			Item itemData) {
		itemRepository.update(itemId, itemData);
		return "redirect:/basic/items/" + itemId;
	}
}

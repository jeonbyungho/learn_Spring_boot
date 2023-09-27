package com.web.item.domain.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.item.domain.web.dto.DeliveryCode;
import com.web.item.domain.web.dto.Item;
import com.web.item.domain.web.dto.enums.ItemType;
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
	
	/**
	 * @ModelAttribute Controller를 호출할 때 (어떤 메서드가 호출되는 지 간에)
	 * model에 자동으로 내용이 담기도록 보장 된다.
	 * <code>model.addAttribute("key name", object)</code>
	 */
	@ModelAttribute("regions")
	public Map<String, String> regions(){
		//HashMap(순서가 보장되지 않음) LinkedHashMap(순서가 보장됨)
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
		return regions;
	}
	
	@ModelAttribute("itemTypes")
	public ItemType[] itemTypes() {
		return ItemType.values();
	}
	
	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes() {
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}
	
	@GetMapping
	public String items(Model model) {
		List<Item> itemsList = itemRepository.findAll();
		model.addAttribute("itemsList", itemsList);
		return "basic/items";
	}
	
	@GetMapping("/{itemId}")
	public String getItem(
			@PathVariable("itemId") Long itemId,
			Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		System.out.println("● get : "+item.toString());
		return "basic/item_obj";
	}
	
	/**상품 추가 페이지 이동*/
	@GetMapping("/add")
	public String getItemAddForm(Model model) {
		model.addAttribute("item", new Item());
		return "basic/addForm";
	}
	
	/**상품 추가
	 * @ModelAttribute("")안 파라미터 명을 생략 시 ,
	 * model에 저장되는 name은 클래스명 첫 글자만 소문자로 등록
	 * <code>Item => itme</code>*/
	@PostMapping("/add")
	//public String saveItem(@ModelAttribute("item") Item itemData) {
	//public String saveItem(@ModelAttribute Item itemData, Model model) {
	//public String saveItem(Item itemData) {
	public String saveItem(@ModelAttribute Item itemData, RedirectAttributes redirect) {
		//System.out.println("┌─itemData save 전 : " + model.getAttribute("item").toString()); id = null
		itemRepository.save(itemData);
		//System.out.println("└─itemData save 후 : " + model.getAttribute("item").toString()); id = {*}
		redirect.addAttribute("status", true);
		System.out.println("● save : " + itemData.toString());
		return "redirect:/basic/items/" + itemData.getId();
	}
	
	/**상품 수정 페이지 이동*/
	@GetMapping("/edit/{itemId}")
	public String getItemEditForm(
			@PathVariable("itemId") Long itemId,
			Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		System.out.println("● getEdit : "+item.toString());
		return "basic/editForm";
	}
	
	/**상품 수정*/
	@PostMapping("/edit/{itemId}")
	public String updatItem(
			@PathVariable("itemId") Long itemId,
			@ModelAttribute Item itemData) {
		System.out.println("● update : "+itemData.toString());
		itemRepository.update(itemId, itemData);
		return "redirect:/basic/items/{itemId}";
	}
}

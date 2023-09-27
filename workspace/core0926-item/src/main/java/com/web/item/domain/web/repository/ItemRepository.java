package com.web.item.domain.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.item.domain.web.dto.Item;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 저장
	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}
	
	// id 조회
	public Item findById(Long id) {
		return store.get(id);
	}
	
	// 전체 조회
	public List<Item> findAll(){
		return new ArrayList<Item>(store.values());
	}
	
	// 수정
	public void update(Long id, Item updatParam) {
		Item findItem = findById(id);
		
		findItem.setItemName(updatParam.getItemName());
		findItem.setPrice(updatParam.getPrice());
		findItem.setQuantity(updatParam.getQuantity());
		findItem.setOpen(updatParam.getOpen());
		findItem.setRegions(updatParam.getRegions());
		findItem.setItemType(updatParam.getItemType());
		findItem.setDeliveryCode(updatParam.getDeliveryCode());
	}
	
	// 저장소 데이터 지움
	public void clearStore() {
		store.clear();
	}
}

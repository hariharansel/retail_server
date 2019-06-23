package com.avenir.retail.bill.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avenir.retail.bill.entities.Item;
import com.avenir.retail.bill.enums.ItemTypeEnum;

@Service
public class ItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private Map<Long, Item> itemsMap;

	@PostConstruct
	private void initItems() {
		LOGGER.info("Pre Loading items ... ");
		// Loads the items at start up this is considered as items from DB.
		itemsMap = new HashMap<>();
		itemsMap.put(1L, new Item(1L, "Samsung 21 inch TV", ItemTypeEnum.Electronics, 350.12));
		itemsMap.put(2L, new Item(2L, "Mi Note 7 Pro", ItemTypeEnum.Electronics, 222.45));
		itemsMap.put(3L, new Item(3L, "U.S Polo T Shirt", ItemTypeEnum.Textiles, 28.5));
		itemsMap.put(4L, new Item(4L, "Vegetable Oil", ItemTypeEnum.Grocery, 5.25));
		itemsMap.put(5L, new Item(5L, "AWS Full Walkthrough", ItemTypeEnum.Books, 12.0));
		itemsMap.put(6L, new Item(6L, "I Phone 10", ItemTypeEnum.Electronics, 1699.00));
		itemsMap.put(7L, new Item(7L, "Azure Full Walthrough", ItemTypeEnum.Books, 11.0));
		itemsMap.put(8L, new Item(8L, "Philips Trimmer", ItemTypeEnum.Health, 20.00));
	}

	/**
	 * Gets the items with price grouped by item type.
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getItems() {
		List<Map<String, Object>> itemsResult = new ArrayList<>();

		// Gets the item as collection.
		Collection<Item> items = itemsMap.values();

		// Groups the items by item type.
		Map<ItemTypeEnum, List<Item>> itemGroupedByType = items.stream()
				.collect(Collectors.groupingBy(Item::getType, Collectors.toList()));

		itemGroupedByType.forEach((itemType, itemList) -> {
			Map<String, Object> itemsMap = new HashMap<>();
			itemsMap.put("itemType", itemType.name());
			itemsMap.put("items", itemList);
		});

		return itemsResult;
	}

	public Item getItem(Long id) {
		return itemsMap.get(id);
	}
}

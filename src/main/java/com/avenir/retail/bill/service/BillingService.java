package com.avenir.retail.bill.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenir.retail.bill.dto.BillDTO;
import com.avenir.retail.bill.entities.Item;
import com.avenir.retail.bill.entities.User;
import com.avenir.retail.bill.enums.ItemTypeEnum;
import com.avenir.retail.bill.enums.UserTypeEnum;
import com.avenir.retail.bill.exception.BadRequestException;
import com.avenir.retail.bill.utils.Constants;

@Service
public class BillingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserService userService;
	@Autowired
	ItemService itemService;

	private Map<UserTypeEnum, Double> userTypeDiscountDetails;

	private List<ItemTypeEnum> discountExcludedItemTypes;

	// For now bill Id is kept static. It will be based on the DB in real time.
	private Long billId = 11234L;

	@PostConstruct
	private void initDiscountDetails() {
		LOGGER.info("Pre Loading duscount details ... ");
		// Considering the discount details are found from DB.
		userTypeDiscountDetails = new HashMap<>();
		userTypeDiscountDetails.put(UserTypeEnum.Employee, 30.0);
		userTypeDiscountDetails.put(UserTypeEnum.Affiliate, 10.0);
		userTypeDiscountDetails.put(UserTypeEnum.Regular, 5.0);

		// Item types on which discount is not valid.
		// This can be made configurable.
		discountExcludedItemTypes = Arrays.asList(ItemTypeEnum.Grocery);
	}

	/**
	 * Generates the bill of the item based on the user and discount available.
	 * 
	 * @param userId
	 * @param itemId
	 * @return
	 */
	public BillDTO getItemGeneratedBill(Long userId, Long itemId) {
		BillDTO billResult = new BillDTO();

		// Gets the user purchasing the item.
		User user = userService.getUser(userId);

		// Validates the user.
		if (user == null) {
			throw new BadRequestException("User is does not exist.");
		}

		// Gets the item for billing.
		Item item = itemService.getItem(itemId);

		// Validates the item.
		if (item == null) {
			throw new BadRequestException("Item given for purchase does not exist.");
		}

		billResult.setId(billId);

		// User details are added in generated bill.
		Map<String, Object> userDetails = new HashMap<>();
		userDetails.put("userId", user.getId());
		userDetails.put("userTypr", user.getType());
		userDetails.put("name", user.getFirstName() + Constants.EMPTY_SPACE + user.getLastName());
		userDetails.put("email", user.getEmail());
		userDetails.put("phoneNumber", user.getPhoneNumber());
		billResult.setUserDetails(userDetails);

		// Item details with original price.
		Map<String, Object> itemDetails = new HashMap<>();
		itemDetails.put("itemId", item.getId());
		itemDetails.put("itemName", item.getName());
		itemDetails.put("itemType", item.getType());
		itemDetails.put("price", item.getPrice());
		billResult.setItemDetails(itemDetails);

		Double originalPrice = item.getPrice();
		Double discountPercentage = 0.0;
		Double discountedAmount = 0.0;
		Double netPayableAmount = 0.0;
		
		// Validates the user eligible for discount and
		// Validates the item eligible for discount.
		if (user.getType() != UserTypeEnum.New && !discountExcludedItemTypes.contains(item.getType())) {
			discountPercentage = userTypeDiscountDetails.get(user.getType());
		}
		
		if (discountPercentage > 0.0) {
			// Finds the amount to discounted if the discount percentage valid.
			discountedAmount = calculateDiscountedAmount(originalPrice, discountPercentage);
		}
		netPayableAmount = originalPrice - discountedAmount;

		// Bill details with price, discount percentage and amount payable.
		Map<String, Object> billDetails = new HashMap<>();
		billDetails.put("originalPrice", originalPrice);
		billDetails.put("discountPercentage", discountPercentage);
		billDetails.put("discountedAmount", discountedAmount);
		billDetails.put("netPayableAmount", netPayableAmount);
		billResult.setBillDetails(billDetails);

		return billResult;
	}

	/**
	 * Calculates the discounted amount from price based on the discount percentage
	 * available.
	 * 
	 * @param price
	 * @param discountPercentage
	 * @return
	 */
	public Double calculateDiscountedAmount(Double price, Double discountPercentage) {
		Double discountedAmount = price * (discountPercentage / 100);
		return discountedAmount;
	}
}

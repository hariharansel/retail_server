package com.avenir.retail.bill.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.avenir.retail.bill.entities.User;
import com.avenir.retail.bill.enums.UserTypeEnum;
import com.avenir.retail.bill.exception.BadRequestException;

@RunWith(SpringRunner.class)
public class BillingServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillingServiceTest.class);
	
	@TestConfiguration
	static class BillingServiceTestContextConfiguration {
		@Bean
		public BillingService DataService() {
			return new BillingService();
		}
	}
	
	@Autowired
	BillingService billingService;
	
	@MockBean
	UserService userService;
	@MockBean
	ItemService itemService;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void userNotExistTest() {
		expectedEx.expect(BadRequestException.class);
		expectedEx.expectMessage("User is does not exist.");
		Long userId = 10L;
		Mockito.when(userService.getUser(userId)).thenReturn(null);
		billingService.getItemGeneratedBill(userId, 1L);
	}
	
	@Test
	public void itemNotExistTest() {
		expectedEx.expect(BadRequestException.class);
		expectedEx.expectMessage("Item given for purchase does not exist.");
		
		User user = new User(1L, "Will", "Smith", "abcd@gmail.com", "+911234567891", UserTypeEnum.Affiliate);
		
		Mockito.when(userService.getUser(1L)).thenReturn(user);
		Mockito.when(itemService.getItem(1L)).thenReturn(null);
		
		billingService.getItemGeneratedBill(1L, 1L);
	}
	
	@Test
	public void calculateDiscountedAmountTest() {
	
		Double discountedAmount = billingService.calculateDiscountedAmount(100.00, 25.0);
		Assert.assertTrue(discountedAmount.equals(25.0));
	}

}

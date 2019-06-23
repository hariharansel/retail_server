package com.avenir.retail.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avenir.retail.bill.dto.BillDTO;
import com.avenir.retail.bill.dto.Response;
import com.avenir.retail.bill.exception.BadRequestException;
import com.avenir.retail.bill.exception.ServerException;
import com.avenir.retail.bill.service.BillingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/retail")
@Api(value = "BillingController")
public class BillingController extends BaseController {

	@Autowired
	BillingService billingService;
	
	/**
	 * Generates the item bill based on the user.
	 * 
	 * @param userId
	 * @param itemId
	 * @return resp
	 */
	@ApiOperation(produces = "application/json", value = "GenerateItemBill", notes = "API to generate the item bill.")
	@RequestMapping(value = "/bill", method = { RequestMethod.GET })
	@ResponseBody
	public Response<BillDTO> getBillDetails(@RequestParam("user_id") Long userId, @RequestParam("item_id") Long itemId) {
		// User ID is got in request for here. But user Id will found from user session.
		assertPositiveNumber(userId, "User ID is invalid.");
		assertPositiveNumber(itemId, "Item ID is invalid.");
		
		Response<BillDTO> resp = new Response<>();
		
		try {
			resp.setResult(billingService.getItemGeneratedBill(userId, itemId));
		} catch (BadRequestException e) {
			throw e;
		} catch (Exception e) {
			throw new ServerException("Error in generating bill details. Please try again later.");
		}
		
		return resp;
	}
}

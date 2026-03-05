

package com.quickcommerce.thiskostha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickcommerce.thiskostha.dto.DeliveryPartnerDTO;
import com.quickcommerce.thiskostha.dto.ResponseStructure;
import com.quickcommerce.thiskostha.entity.DeliveryPartner;
import com.quickcommerce.thiskostha.service.DeliveryPartnerService;
import com.quickcommerce.thiskostha.service.RedisService;

@RestController
	@RequestMapping("/deliverypartner")
	public class DeliveryPartnerController {
		@Autowired
		private DeliveryPartnerService deliveryPartnerService;

		 @Autowired
		    private RedisService redisService;
		@PostMapping("/register")
		public ResponseEntity<ResponseStructure<DeliveryPartner>> register(@RequestBody DeliveryPartnerDTO deliveryPartnerdto){
			return deliveryPartnerService.register(deliveryPartnerdto); 
		}
		@GetMapping("/finddeliverypartner/{phoneno}")
		public ResponseEntity<ResponseStructure<DeliveryPartner>> findDeliveryPartner(@RequestParam String phone){
			return deliveryPartnerService.findDeliveryPartner(phone);
		}
		@DeleteMapping("/deletedeliverypartner/{phoneno}")
		public ResponseEntity<ResponseStructure<DeliveryPartner>> deleteDeliveryPartner(@RequestParam String phone){
			return deliveryPartnerService.deleteDeliveryPartner(phone);	
		}

	    @PostMapping("/updateDpLoc")
	    public ResponseEntity<String> updateDpLoc(@RequestParam Integer partnerid, @RequestParam double latitude, double longitude) {
	        String s = redisService.updateDpLoc(partnerid, latitude, longitude);
	        return new ResponseEntity<>(s, HttpStatus.OK);
	    }

	    @PostMapping("/acceptorder")
	    public String acceptorder(@RequestParam Long orderid, @RequestParam Long partnerid) {
	        boolean accepted = deliveryPartnerService.acceptorder(orderid, partnerid);

	        return accepted ? "Order Assigned Successfully" : "Order Already Taken";
	    }
}

	

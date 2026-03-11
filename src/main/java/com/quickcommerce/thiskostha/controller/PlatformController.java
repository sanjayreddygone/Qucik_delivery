package com.quickcommerce.thiskostha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickcommerce.thiskostha.dto.ResponseStructure;
import com.quickcommerce.thiskostha.entity.Coupon;
import com.quickcommerce.thiskostha.service.PlatformService;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping("/createcoupon")
    public ResponseEntity<ResponseStructure<Coupon>> createCoupon(
            @RequestBody Coupon coupon){
        return platformService.createCoupon(coupon);
    }

    @DeleteMapping("/deletecoupon")
    public ResponseEntity<ResponseStructure<String>> deleteCoupon(
            @RequestParam Integer couponId){
        return platformService.deleteCoupon(couponId);
    }

    @PatchMapping("/updatecoupon")
    public ResponseEntity<ResponseStructure<Coupon>> updateCoupon(
            @RequestParam Integer couponId,
            @RequestParam String expiryDate){
        return platformService.updateCoupon(couponId, expiryDate);
    }

    @GetMapping("/findcoupon")
    public ResponseEntity<ResponseStructure<Coupon>> findCoupon(
            @RequestParam Integer couponId){
        return platformService.findCoupon(couponId);
    }
}
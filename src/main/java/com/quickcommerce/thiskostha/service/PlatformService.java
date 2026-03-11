package com.quickcommerce.thiskostha.service;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quickcommerce.thiskostha.dto.ResponseStructure;
import com.quickcommerce.thiskostha.entity.Coupon;
import com.quickcommerce.thiskostha.repository.CouponRepository;
import com.quickcommerce.thiskostha.repository.CouponredemptionReposiotry;

@Service
public class PlatformService {

    private final CouponRepository couponRepo;
    private final CouponredemptionReposiotry couponRedemptionRepo;

    public PlatformService(CouponRepository couponRepo,
    		CouponredemptionReposiotry couponRedemptionRepo) {
        this.couponRepo = couponRepo;
        this.couponRedemptionRepo = couponRedemptionRepo;
    }

    // CREATE COUPON
    public ResponseEntity<ResponseStructure<Coupon>> createCoupon(Coupon coupon){

        Coupon savedCoupon = couponRepo.save(coupon);

        ResponseStructure<Coupon> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.CREATED.value());
        rs.setMessage("Coupon Created Successfully");
        rs.setData(savedCoupon);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    // DELETE COUPON
    public ResponseEntity<ResponseStructure<String>> deleteCoupon(Integer couponId){

        Coupon coupon = couponRepo.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        if(couponRedemptionRepo.existsByCoupon(coupon)){
            throw new RuntimeException(
                    "Coupon already used by customers, cannot delete");
        }

        couponRepo.delete(coupon);

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Coupon Deleted Successfully");
        rs.setData("Deleted");

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // UPDATE COUPON
    public ResponseEntity<ResponseStructure<Coupon>> updateCoupon(
            Integer couponId,
            String expiryDate){

        Coupon coupon = couponRepo.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        boolean used = couponRedemptionRepo.existsByCoupon(coupon);

        if(!used){
            coupon.setExpiryDate(LocalDate.parse(expiryDate));
        } else {
            if(coupon.getMaxCoupons() > 0){
                coupon.setMaxCoupons(coupon.getMaxCoupons() - 1);
            }
        }

        Coupon updatedCoupon = couponRepo.save(coupon);

        ResponseStructure<Coupon> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Coupon Updated Successfully");
        rs.setData(updatedCoupon);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // FIND COUPON
    public ResponseEntity<ResponseStructure<Coupon>> findCoupon(Integer couponId){

        Coupon coupon = couponRepo.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        ResponseStructure<Coupon> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Coupon Fetched Successfully");
        rs.setData(coupon);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
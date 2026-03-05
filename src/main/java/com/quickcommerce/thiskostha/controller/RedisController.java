package com.quickcommerce.thiskostha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.quickcommerce.thiskostha.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	    @Autowired
	    private RedisService redisService;
	    
	    @PostMapping("/updateLocation")
		public String updateDPloc(Integer dpid, double latitude, double longitude) {
			return redisService. updateDpLoc(dpid,latitude,longitude);

		}
	}

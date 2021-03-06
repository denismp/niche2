/**
 * 
 */
package com.ebusiness.niche.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebusiness.niche.entity.ShipmentInfo;
import com.ebusiness.niche.service.ShipmentInfoService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class ShipmentInfoController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ShipmentInfoService shipmentInfoService;
	
	@ResponseBody
	@RequestMapping(value = {"/shipmentinfo"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ShipmentInfo>> getShipmentInfos() {
		log.info("getShipmentInfos(): Called...");
		
		List<ShipmentInfo> list = null;
		
		list = this.shipmentInfoService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getShipmentInfos(): returned a null or empty list.");
			ResponseEntity<List<ShipmentInfo>> rVal = new ResponseEntity<List<ShipmentInfo>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<ShipmentInfo>>(list, HttpStatus.OK);		
	}

}

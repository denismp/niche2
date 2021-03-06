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

import com.ebusiness.niche.entity.ParentAsin;
import com.ebusiness.niche.service.ParentAsinService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class ParentAsinController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParentAsinService parentAsinService;
	
	@ResponseBody
	@RequestMapping(value = {"/parentasin"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ParentAsin>> getParentAsins() {
		log.info("getParentAsins(): Called...");
		
		List<ParentAsin> list = null;
		
		list = this.parentAsinService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getParentAsins(): returned a null or empty list.");
			ResponseEntity<List<ParentAsin>> rVal = new ResponseEntity<List<ParentAsin>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<ParentAsin>>(list, HttpStatus.OK);		
	}

}

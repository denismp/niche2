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

import com.ebusiness.niche.entity.OurCompany;
import com.ebusiness.niche.service.OurCompanyService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class OurCompanyController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OurCompanyService ourCompanyService;
	
	@ResponseBody
	@RequestMapping(value = {"/ourcompany"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<OurCompany>> getOurCompanys() {
		log.info("getOurCompanys(): Called...");
		
		List<OurCompany> list = null;
		
		list = this.ourCompanyService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getOurCompanys(): returned a null or empty list.");
			ResponseEntity<List<OurCompany>> rVal = new ResponseEntity<List<OurCompany>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<OurCompany>>(list, HttpStatus.OK);		
	}

}

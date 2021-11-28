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

import com.ebusiness.niche.entity.CompetitorsToTarget;
import com.ebusiness.niche.service.CompetitorsToTargetService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class CompetitorsToTargetController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompetitorsToTargetService competitorsToTargetService;
	
	@ResponseBody
	@RequestMapping(value = {"/competitorstotarget"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<CompetitorsToTarget>> getCompetitorsToTarget() {
		log.info("getCompetitorsToTarget(): Called...");
		
		List<CompetitorsToTarget> list = null;
		
		list = this.competitorsToTargetService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getCompetitorsToTarget(): returned a null or empty list.");
			ResponseEntity<List<CompetitorsToTarget>> rVal = new ResponseEntity<List<CompetitorsToTarget>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<CompetitorsToTarget>>(list, HttpStatus.OK);		
	}

}

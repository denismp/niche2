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

import com.ebusiness.niche.entity.Product;
import com.ebusiness.niche.service.ProductService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/niche" )
public class ProductController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(value = {"/product"}, method = { RequestMethod.GET })
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Product>> getProducts() {
		log.info("getProducts(): Called...");
		
		List<Product> list = null;
		
		list = this.productService.findAll();
		
		if( list == null || list.isEmpty() ) {
			log.info("getProducts(): returned a null or empty list.");
			ResponseEntity<List<Product>> rVal = new ResponseEntity<List<Product>>(list, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);		
	}

}

package com.unir.springboot.app.msitem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unir.springboot.app.msitem.models.Item;
import com.unir.springboot.app.msitem.service.IItemService;

@RefreshScope
@RestController
@Qualifier("serviceFeign")
public class ItemController {
	
	private static Logger log = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IItemService itemService;
	
	@Value("${config.text}")
	private String configText; 
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item ver(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	@GetMapping("/View-Config")
	public ResponseEntity<?> ViewConfig(@Value("${server.port}") String port){
		log.info(configText);
		Map<String, String> resp = new HashMap<>();
		resp.put("configText", configText);
		resp.put("port", port);
		
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			resp.put("DevName", env.getProperty("config.dev.name"));
			resp.put("DevEmail", env.getProperty("config.dev.email"));
		}
		
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.OK);
	}
}

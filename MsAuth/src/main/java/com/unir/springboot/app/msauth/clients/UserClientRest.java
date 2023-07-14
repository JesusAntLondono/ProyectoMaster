package com.unir.springboot.app.msauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unir.springboot.app.msauth.models.User;

@FeignClient(name = "service-msusers")
public interface UserClientRest {

	@GetMapping("/ver/{username}")
	public User Ver(@PathVariable String username);

}

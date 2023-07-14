package com.unir.springboot.app.msauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.unir.springboot.app.msauth.models.User;
import com.unir.springboot.app.msauth.service.IAuthService;


@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IAuthService authService ;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		User usuario = authService.findByUsername(authentication.getName());
		info.put("nombre", usuario.getName());
		info.put("apellido", usuario.getLastName());
		info.put("correo", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
}
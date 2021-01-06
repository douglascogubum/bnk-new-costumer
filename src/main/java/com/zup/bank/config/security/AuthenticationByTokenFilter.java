package com.zup.bank.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zup.bank.model.User;
import com.zup.bank.repository.UserRepository;
import com.zup.bank.services.TokenService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationByTokenFilter extends OncePerRequestFilter{

	private static final int INITIAL_POSITION = 7;
	
	private TokenService tokenService;
	private UserRepository repository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recoveryToken(request);
		boolean isValid = tokenService.isTokenValid(token);
		if(isValid) {
			authenticateCostumer(token);
		}
		filterChain.doFilter(request, response);		
	}

	private void authenticateCostumer(String token) {
		Long idUser = tokenService.getIsUser(token);
		User user = repository.findById(idUser).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}

	private String recoveryToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer")) {
			return null;
		}
		return token.substring(INITIAL_POSITION, token.length());
	}

}

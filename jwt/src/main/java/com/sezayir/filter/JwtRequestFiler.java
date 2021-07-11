package com.sezayir.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sezayir.service.JwtUserDetailsService;
import com.sezayir.utiltoken.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFiler  extends OncePerRequestFilter{
	
	private static final Logger log = LoggerFactory.getLogger(JwtRequestFiler.class);
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private JwtUserDetailsService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String  requestTokenHeader=request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
	
		try {
			if(requestTokenHeader!=null & requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.split(",")[1];
				username=jwtUtils.getUsernameFromToken(jwtToken);	
				log.info("user name is :"+username);
			}
			else {
				log.warn("JWT Token does not begin with Bearer String");
			}
		} catch (IllegalArgumentException e) {
			log.error("Unable to get JWT Token");
		} catch (ExpiredJwtException e) {
			log.error("JWT Token has expired");
		}
			
		//Once we get the token validate it.
		
		if(username!=null   && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetail = jwtService.loadUserByUsername(username);
			// if token is valid configure Spring Security to manually set authentication
			if(jwtUtils.validateToken(jwtToken, userDetail)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetail, null,userDetail.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
		}
		filterChain.doFilter(request, response);
		
	}

}

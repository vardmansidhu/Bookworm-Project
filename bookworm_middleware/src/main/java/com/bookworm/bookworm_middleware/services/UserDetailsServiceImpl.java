//package com.bookworm.bookworm_middleware.services;
//
//import java.util.ArrayList;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	private String password;
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new User(username, password, new ArrayList<>());
//	}
//
//}

package com.example.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository r;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = r.findByUsername(username);
		return new MyUserDetails(user);
	}

}

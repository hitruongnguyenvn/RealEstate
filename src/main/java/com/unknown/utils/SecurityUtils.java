package com.unknown.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.unknown.model.MyUserDetails;

public class SecurityUtils {

	public static MyUserDetails getPrincipal() {
		return (MyUserDetails) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
	}

	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}
}

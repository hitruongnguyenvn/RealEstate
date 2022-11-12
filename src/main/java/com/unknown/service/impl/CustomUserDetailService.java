package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unknown.entity.UsersEntity;
import com.unknown.model.MyUserDetails;
import com.unknown.repository.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UsersEntity usersEntity = usersRepository.findOneByUserName(name);
		if (usersEntity == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + usersEntity.getRoleEntity().getCode()));
		MyUserDetails myUserDetails = new MyUserDetails(name, usersEntity.getPassword(), true, true, true, true,
				authorities);
		myUserDetails.setFullName(usersEntity.getFullName());
		myUserDetails.setId(usersEntity.getId());
		return myUserDetails;
		/*
		 * UserDTO userDTO = userService.findOneByUserNameAndStatus(name, 1); if
		 * (userDTO == null) { throw new
		 * UsernameNotFoundException("Username not found"); } List<GrantedAuthority>
		 * authorities = new ArrayList<>(); for (RoleDTO role : userDTO.getRoles()) {
		 * authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode())); }
		 * MyUserDetail myUserDetail = new MyUserDetail(name, userDTO.getPassword(),
		 * true, true, true, true, authorities); BeanUtils.copyProperties(userDTO,
		 * myUserDetail); return myUserDetail;
		 */
	}
}

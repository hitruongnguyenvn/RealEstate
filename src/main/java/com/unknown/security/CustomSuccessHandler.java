package com.unknown.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.unknown.constant.RoleConstant;
import com.unknown.constant.SystemConstant;
import com.unknown.utils.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isUser(roles)) {
			url = SystemConstant.HOME;
		} else if (isAdmin(roles)) {
			url = SystemConstant.ADMIN_HOME;
		} else if (isManager(roles)) {
			url = SystemConstant.ADMIN_HOME;
		}
		return url;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains(RoleConstant.ROLE_ADMIN)) {
			return true;
		}
		return false;
	}

	private boolean isManager(List<String> roles) {
		if (roles.contains(RoleConstant.ROLE_MANAGE)) {
			return true;
		}
		return false;
	}

	private boolean isUser(List<String> roles) {
		if (roles.contains(RoleConstant.ROLE_USER)) {
			return true;
		}
		return false;
	}
}

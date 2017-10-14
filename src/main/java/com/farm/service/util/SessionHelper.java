package com.farm.service.util;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.farm.rest.dto.response.FarmLoginResponseDto;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class SessionHelper {

	private FarmLoginResponseDto loginSession;

	public FarmLoginResponseDto getLoginSession() {
		return loginSession;
	}

	public void setLoginSession(FarmLoginResponseDto loginSession) {
		this.loginSession = loginSession;
	}

}

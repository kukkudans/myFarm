package com.farm.service.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.rest.dto.response.FarmLoginResponseDto;

@Component
public class UserAutherizationService {

	@Autowired
	private SessionHelper sessionHelper;

	public boolean isAuthenticated(String token) {
		if (StringUtils.isEmpty(token)) {
			return false;
		}

		FarmLoginResponseDto userSession = sessionHelper.getLoginSession();
		if (userSession == null) {
			return false;
		}

		return StringUtils.equalsIgnoreCase(token, userSession.getToken());
	}

}

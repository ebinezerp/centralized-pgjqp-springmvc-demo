package spring.webapp.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import spring.webapp.dto.User;

@Component
public class UserValidation {

	public Map<String, String> validate(User user) {
		Map<String, String> errorMessages = new HashMap<String, String>();
		if (user.getFullname().isEmpty()) {
			errorMessages.put("fullnameError", "Enter name");
		}

		if (user.getEmail().isEmpty()) {
			errorMessages.put("emailError", "Enter valid Email");
		}

		if (user.getMobile().isEmpty()) {
			errorMessages.put("mobileError", "Enter mobile number");
		}

		if (user.getPassword().isEmpty()) {
			errorMessages.put("passwordError", "Enter password");
		}
		return errorMessages;
	}

}

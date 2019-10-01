package com.chavis.biz.client.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.chavis.biz.client.vo.ClientVO;

public class ClientValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		ClientVO vo = (ClientVO) target;
		if (vo.getClient_id() == null || vo.getClient_id().trim().isEmpty()) {
			errors.rejectValue("client_id", "required");
		}
		if (vo.getClient_name() == null || vo.getClient_name().trim().isEmpty()) {
			errors.rejectValue("client_name", "required", new Object[] { "client_name" }, "input name");
		}
		if (vo.getPassword() == null || vo.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		}
		if (vo.getTel() == null || vo.getTel().trim().isEmpty()) {
			errors.rejectValue("tel", "required", new Object[] { "tel" }, "input tel");
		}
	}
}

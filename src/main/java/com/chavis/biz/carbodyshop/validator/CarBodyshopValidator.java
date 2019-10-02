package com.chavis.biz.carbodyshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;
import com.chavis.biz.client.vo.ClientVO;

public class CarBodyshopValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		CarBodyshopVO vo = (CarBodyshopVO) target;
		if (vo.getBody_id() == null || vo.getBody_id().trim().isEmpty()) {
			errors.rejectValue("body_id", "required");
		}
//		if (vo.get == null || vo.getClient_name().trim().isEmpty()) {
//			errors.rejectValue("client_name", "required", new Object[] { "client_name" }, "input name");
//		}
		if (vo.getBody_pw() == null || vo.getBody_pw().trim().isEmpty()) {
			errors.rejectValue("body_pw", "required");
		}
//		if (vo.getTel() == null || vo.getTel().trim().isEmpty()) {
//			errors.rejectValue("tel", "required", new Object[] { "tel" }, "input tel");
//		}
	}
}

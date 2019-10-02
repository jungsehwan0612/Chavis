package com.chavis.biz.carbodyshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

public class CarBodyshopValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		CarBodyshopVO vo = (CarBodyshopVO) target;
		if (vo.getBodyshop_id() == null || vo.getBodyshop_id().trim().isEmpty()) {
			errors.rejectValue("bodyshop_id", "required");
		}
//		if (vo.get == null || vo.getClient_name().trim().isEmpty()) {
//			errors.rejectValue("client_name", "required", new Object[] { "client_name" }, "input name");
//		}
		if (vo.getBodyshop_pw() == null || vo.getBodyshop_pw().trim().isEmpty()) {
			errors.rejectValue("bodyshop_pw", "required");
		}
//		if (vo.getTel() == null || vo.getTel().trim().isEmpty()) {
//			errors.rejectValue("tel", "required", new Object[] { "tel" }, "input tel");
//		}
	}

}

package com.unknown.validation;

import com.unknown.custom.exception.FormatException;
import com.unknown.model.request.AreaUpdateRequest;

public class AreaValidator {

	public static void validation(AreaUpdateRequest updateRequest) {
		if (!updateRequest.getArea().toString().matches("^[0-9]+$")) {
			throw new FormatException("Area wrong format");
		}
		if (!updateRequest.getPrice().toString().matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
			throw new FormatException("Price wrong format");
		}
		if (!updateRequest.getFloor().toString().matches("^\\-?[0-9]+$")) {
			throw new FormatException("Floor wrong format");
		}
	}
}

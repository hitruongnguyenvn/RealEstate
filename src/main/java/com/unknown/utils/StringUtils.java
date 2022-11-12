package com.unknown.utils;

public class StringUtils {
	public static boolean isNullOrEmpty(String value) {
		if (value != null && !value.isEmpty()) {
			return false;
		}
		return true;
	}

	public static String convertToFieldNameSqlServer(String fieldName) {
		StringBuilder newFiledName = new StringBuilder();
		for (int i = 0; i < fieldName.length(); i++) {
			Character character = fieldName.charAt(i);
			if (character >= 'A' && character <= 'Z') {
				character = Character.toLowerCase(character);
				newFiledName.append("_");
				newFiledName.append(character);
			} else {
				newFiledName.append(character);
			}
		}
		return newFiledName.toString();
	}
}

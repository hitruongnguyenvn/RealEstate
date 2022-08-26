package com.unknown.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getValue(Map<String, Object> prams, String key, Class<T> tClass) {
		Object obj = prams.getOrDefault(key, null);
		if (obj != null) {
			String value = obj.toString().trim();
			try {
				if (tClass.getTypeName().equals("java.lang.Integer")) {
					obj = Integer.parseInt(value);
				} else if (tClass.getTypeName().equals("java.lang.Long")) {
					obj = Long.parseLong(value);
				} else if (tClass.getTypeName().equals("java.lang.String")) {
					obj = value;
				} else if (tClass.getTypeName().equals("java.lang.Float")) {
					obj = Float.parseFloat(value);
				}
				return tClass.cast(obj);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}
}

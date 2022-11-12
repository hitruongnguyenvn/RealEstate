package com.unknown.utils;

import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map.Entry;

public final class ValidationUtil {
	public static boolean checkDateYMD(String strDate) {
		if (strDate != null && !"".equals(strDate.trim())) {
			// /01/
			// /1/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
			sdf.setLenient(false);// Not allow change : 32/01 => 01/02
			try {
				sdf.parse(strDate);
				return true;
			} catch (Exception e) {
			}
		}
		return false;

	}

	public static java.util.Date checkDateYMDReturn(String strDate) {
		if (strDate != null && !"".equals(strDate.trim())) {
			// /01/
			// /1/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
			sdf.setLenient(false);// Not allow change : 32/01 => 01/02
			try {
				java.util.Date date = sdf.parse(strDate);
				return date;
			} catch (Exception e) {
			}
		}
		return null;

	}

	public static Entry<Boolean, java.util.Date> checkDateYMDReturn2(String strDate) {
		if (strDate != null && !"".equals(strDate.trim())) {
			// /01/
			// /1/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
			sdf.setLenient(false);// Not allow change : 32/01 => 01/02
			try {
				java.util.Date date = sdf.parse(strDate);
				return new AbstractMap.SimpleEntry(true, date);
			} catch (Exception e) {
			}
		}
		return new AbstractMap.SimpleEntry(false, null);

	}

	public static boolean checkDateYMDReturn(String strDate, java.util.Date dateOutput) {
		if (strDate != null && !"".equals(strDate.trim())) {
			// /01/// /1/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
			sdf.setLenient(false);// Not allow change : 32/01 => 01/02
			try {
				java.util.Date date = sdf.parse(strDate);
				// dateOutput = date;
				// Dont Return new Value
				// dateOutput.setYear(date.getYear());
				// dateOutput.setMonth(date.getMonth());
				// dateOutput.setDate(date.getDate());
				// dateOutput.setHours(date.getHours());
				// dateOutput.setMinutes(date.getMinutes());
				// dateOutput.setSeconds(date.getSeconds());
				dateOutput.setTime(date.getTime());
				return true;
			} catch (Exception e) {
			}
		}
		return false;

	}

	public static boolean check18(java.util.Date date) {
		if (date != null) {
			java.util.Date now = new Date();
			// Check >= 18years
			// Check only Date, not check Time
			// SQL SERVER
			// SYSDATETIME()
			// cast(DATEADD(YEAR , 18 , GiáTri) as date) <= cast(GETDATE() asdate)
			date = new Date(date.getYear() + 18, date.getMonth(), date.getDate()); // Add 18Year + Remove Time
			now = new Date(now.getYear(), now.getMonth(), now.getDate()); // Remove Time
			System.out.println(date);
			System.out.println(now);
			// if(date.compareTo(now) <=0)
			if (date.before(now) || date.equals(now)) {
				return true;
			}
		}
		return false;

	}

	public static void checkDateYMDThrow(String strDate) {
		if (strDate != null && !"".equals(strDate.trim())) {
			// /01/
			// /1/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
			sdf.setLenient(false);// Not allow change : 32/01 => 01/02
			try {
				sdf.parse(strDate);
				return;
			} catch (Exception e) {
			}
		}
		// throw new FormatDateException("Ngày không đúng format yyyy/M/d");
	}
}

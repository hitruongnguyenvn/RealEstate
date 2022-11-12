package com.unknown.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtil {

	private static Scanner sc = new Scanner(System.in);

	public static String readString(String message) {
		return readString(message, false, null);
	}

	public static String readString(String message, boolean isRequired, String format) {
		do {
			System.out.print(message);
			String valInput = sc.nextLine();

			if (isRequired && "".equals(valInput)) {
				System.out.println("Bắt buộc phải nhập giá trị.");
				continue;
			}

			// if (!isRequired || (isRequired && !"".equals(valInput)))
			{
				if (format == null || "".equals(format)) {
					return valInput;
				}

				if (valInput.matches(format)) {
					return valInput;
				}
			}
			System.out.println("Sai format, Hãy nhập lại");
		} while (true);
	}

	public static int readInt(String message) {
		do {
			try {
				System.out.print(message);
				return Integer.parseInt(sc.nextLine());
			} catch (Exception ex) {
			}
			System.out.println("Sai format, Hãy nhập lại");
		} while (true);
	}

	public static double readDouble(String message) {
		do {
			try {
				System.out.print(message);
				return Double.parseDouble(sc.nextLine());
			} catch (Exception ex) {
			}
			System.out.println("Sai format, Hãy nhập lại");
		} while (true);
	}

	public static java.util.Date readDate(String message, boolean isRequied) {
		return readDate(message, isRequied, new Date());
	}

	public static java.util.Date readDate(String message, boolean isRequired, java.util.Date maxDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		do {
			try {
				System.out.print(message);
				String valInput = sc.nextLine();

				if (!isRequired && "".equals(valInput)) {
					return null;
				}

				if (isRequired && "".equals(valInput)) {
					System.out.println("Bắt buộc phải nhập giá trị.");
					continue;
				}

				java.util.Date valDate = sdf.parse(valInput);

				if (maxDate == null) {
					return valDate;
				}

				if (valDate.getTime() <= maxDate.getTime()) {
					return valDate;
				}
			} catch (Exception ex) {
			}
			System.out.println("Sai format, Hãy nhập lại");
		} while (true);

	}
}

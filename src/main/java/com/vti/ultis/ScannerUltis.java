package com.vti.ultis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("Sai định dạng. Phải nhập vào số");
			}
		}
	}

	public static int inputInt2() {
		while (true) {
			try {
				int inputInt2 = Integer.parseInt(sc.next().trim());
				if (inputInt2 > 0 && inputInt2 <= 10) {
					return inputInt2;
				} else {
					System.err.println("Sai định dạng. Phải nhập vào số");
				}
			} catch (Exception e) {
				System.err.println("Sai định dạng. Phải nhập vào số");
			}
		}
	}

	public static Float inputFloadt() {
		while (true) {
			try {
				Float inputFloadt = Float.parseFloat(sc.next().trim());
				return inputFloadt;
			} catch (Exception e) {
				System.err.println("Sai định dạng. Phải nhập vào số");
			}
		}
	}

	public static LocalDate inputLocalDate() {
		System.out.println();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.next().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Sai định dạng. Phải nhập theo định dạng: yyyy-MM-dd");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String input = sc.next().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println("Không thể để trống");
			}
		}
	}

	public static int inputScore() {
		while (true) {
			try {
				int inputInt2 = Integer.parseInt(sc.next().trim());
				if (inputInt2 > 0 && inputInt2 <= 10) {
					return inputInt2;
				} else {
					System.err.println("Chỉ nhập từ 1 - 10");
				}
			} catch (Exception e) {
				System.err.println("Sai định dạng. Mời nhập lại");
			}
		}
	}

	public static String inputEmail() {
		while (true) {
			String email = ScannerUltis.inputString();
			if (email == null || !email.contains("@vti.com.vn")) {
				System.err.println("Xin nhập đúng định dạng email: ...@vti.com.vn");
			} else {
				return email;
			}
		}
	}

	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ScannerUltis.inputInt2();
			if (number >= a && number <= b) {
				return number;
			} else {
				System.out.println(errorMessage);
			}
		}
	}

	public static String inputPassword() {
		while (true) {
			String password = ScannerUltis.inputString();
			if (password.length() < 6 || password.length() > 12) {
				System.out.println("Mời nhập lại");
				continue;
			}
			boolean hasAtLeast1Character = false;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println("Mời bạn nhập lại password: bao gồm 6-12 kí tự và tối thiểu 1 kí tự viết hoa");
			}
		}
	}

	public static String inputPhonenumber() {

		while (true) {
			String phonnumber = ScannerUltis.inputString();
			if (phonnumber.length() < 9 || phonnumber.length() > 12) {
				System.err.println("Không thể nhập quá 12 số");
				continue;
			}
			if (phonnumber.charAt(0) != '0') {
				System.err.println("Số đầu tiên phải là 0");
				continue;
			}
			boolean isNumber = true;
			for (int i = 0; i < phonnumber.length(); i++) {
				if (Character.isDigit(phonnumber.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return phonnumber;
			} else {
				System.err.println("Mời nhập lại theo định dạng");
			}
		}
	}

	public static String inputFullname() {
		while (true) {
			boolean flag = true;
			boolean flag1 = true;
			String ckeckname = "\\D+";
			String checkname1 = "\\w+";
			String fullname = ScannerUltis.inputString();
			flag = fullname.matches(ckeckname);
			flag1 = fullname.matches(checkname1);
			if (!flag) {
				System.err.println("Tên chỉ bao gôm chữ cái. Mời nhập lại");
				continue;
			} else if (!flag1) {
				System.err.println("Tên chỉ bao gôm chữ cái. Mời nhập lại");
				continue;
			} else {
				return fullname;
			}
		}
	}
}
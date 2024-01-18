package com.jci.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class BharatUtils {

	public static String sha1encording(String pass) {
		String sha1 = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.reset();
			messageDigest.update(pass.getBytes("UTF-8"));
			sha1 = byteToHex(messageDigest.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha1;
	}



	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static boolean isNotEmpty(final Collection<?> val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final Map<?, ?> val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final Object val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final Object[] val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final String val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final String[] val) {
		return !BharatUtils.isEmpty(val);
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isEmpty(final Integer[] val) {
		boolean status = false;
		if (val == null) {
			status = true;
		} else if (val.length < 1) {
			status = true;
		}
		return status;
	}

	/**
	 * Counter part for isEmpty.
	 *
	 * @param val
	 * @return
	 */
	public static boolean isNotEmpty(final Integer[] val) {
		return !isEmpty(val);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(final Collection val) {
		return (val == null || (val.size() == 0));
	}

	/**
	 * This method checks to see if the given Map is null or contains no object.
	 *
	 * @param val passed Map object
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(final Map val) {
		return (val == null || (val.size() == 0));
	}

	/**
	 * This method checks to see if the given Object is null or not.
	 *
	 * @param obj object to be checked
	 * @return boolean
	 */
	public static boolean isEmpty(final Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			return isEmpty((String) obj);
		}
		return false;
	}

	/**
	 * This method checks to see if the given String is null or blank.
	 *
	 * @param val passed String object
	 * @return boolean
	 */
	public static boolean isEmpty(final String val) {
		return (val == null || val.trim().equals(""));
	}

	/**
	 * This method checks whether the given String is purely numeric.
	 *
	 * @param str A non-null string
	 * @return boolean If str is alphabetic
	 */
	public static boolean isNumeric(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return str.matches("[0-9]*");
	}

	/**
	 * This method checks whether the given String is numeric with decimal.
	 *
	 * @param str A non-null string
	 * @return boolean If str is alphabetic
	 */
	public static boolean isNumericAndDecimal(String str) {
		try {
			Float.parseFloat(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public static Date stringToDateConverter(String strDate, String format) {
		String form = "yyyy-MM-dd";
		if (format != null) {
			form = format;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(form);
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.parse(strDate, formatter);
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		return date;

	}

	public static String dateToStringConverter(Date date, String format) {
		String form = "yyyy-MM-dd";
		if (format != null) {
			form = format;
		}
		SimpleDateFormat sid = new SimpleDateFormat(form);
		String strDate = sid.format(date);
		return strDate;
	}

	public static String strToBase64(File file) {
		StringBuffer buffer = new StringBuffer();
		byte[] input_file = null;
		try {
			input_file = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		byte[] encodedBytes = Base64.getEncoder().encode(input_file);
		buffer.append(Constants.DATA_IMAGE_BASE64.replace("##", FilenameUtils.getExtension(file.getAbsolutePath())));
		buffer.append(new String(encodedBytes));

		}catch(Exception ex) {



		}
		return buffer.toString();
	}


	public static String strToBase64Pdf(File file) {
		StringBuffer buffer = new StringBuffer();
		byte[] input_file = null;
		try {
			input_file = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		byte[] encodedBytes = Base64.getEncoder().encode(input_file);
		buffer.append("data:application/pdf;base64,");
		//buffer.append("^data:application/##[^;]*;base64,?".replace("##", FilenameUtils.getExtension(file.getAbsolutePath())));
		buffer.append(new String(encodedBytes));

		}catch(Exception ex) {



		}
		return buffer.toString();
	}

	public static void main(String args) {
	//	File file = new File("C:\\BhelFilePath\\query_solution_file\\2237_new_resume_2020-converted.pdf");
	//	String fileo =BharatUtils.strToBase64Pdf(file);
		System.out.println("file output :::"+sha1encording("9cab53267f0f6859c45602a6ffa7198b5cacf417"));
	}
}

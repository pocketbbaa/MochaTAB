package com.tab.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author wangqingsongs
 *
 */
public class PublicUtil {

	public static final int HASH_INVITE_CODE = 830411;

	/***
	 * 取得.properties文件的内容,返回Properties对象;
	 * 
	 * @param proPath
	 * @return
	 */
	public static Properties getProperties(String proPath) {
		if (proPath == null || proPath.trim().length() <= 0) {
			return null;
		}
		Properties props = new Properties();
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(new File(PublicUtil.class.getClassLoader().getResource(proPath).getFile()));// new
																														// FileInputStream(proPath);
			props.load(inputFile);
			return props;
		} catch (Exception exp) {
			exp.printStackTrace();
			Log4jUtil.exception(exp);
		} finally {
			if (inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException exp) {
					Log4jUtil.exception(exp);
				}
			}
		}
		return null;
	}

	/***
	 * 得到Boolean对象的值, 如果对象为null, 则返回false;
	 * 
	 * @param booln
	 * @return
	 */
	public static final boolean getBooleanValue(Boolean booln) {
		if (booln == null) {
			return false;
		} else {
			return booln.booleanValue();
		}
	}

	/***
	 * 得到trim后的字符串;如果字符串为null,则返回空串;
	 * 
	 * @param str
	 * @return
	 */
	public static final String getTrimIfNullValueBlank(String str) {
		if (str == null || str.trim().length() == 0) {
			return "";
		}
		return str.trim();
	}

	/***
	 * 得到trim后的字符串;如果字符串为null或者为"",则返回NULL;
	 * 
	 * @param str
	 * @return
	 */
	public static final String getTrimIfBlankValueNULL(String str) {
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		return str.trim();
	}

	/***
	 * 获取客户端IP地址;这里通过了Nginx获取;X-Real-IP,
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		// String fromSource = "X-Real-IP";
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
			// fromSource = "X-Forwarded-For";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			// fromSource = "Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			// fromSource = "WL-Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			// fromSource = "request.getRemoteAddr";
		}
		// appLog.info("App Client IP: "+ip+", fromSource: "+fromSource);
		return ip;
	}

	/***
	 * 把字符串左边的第一个0去点;
	 * 
	 * @param str
	 * @return
	 */
	public static String trimLeftFirst0(String str) {
		if (str == null || str.trim().length() == 0) {
			return "";
		}
		str = str.trim();
		if (str.startsWith("0")) {
			return str.substring(1, str.length());
		}
		return str.trim();
	}

	/***
	 * 根据用户ID生成邀请码;
	 * 
	 * @param userID
	 * @return
	 */
	public final static int getInviteCode(int userID) {
		return HASH_INVITE_CODE + userID;
	}

	/***
	 * 通过邀请码获得用户ID;
	 * 
	 * @param InviteCode
	 * @return
	 */
	public final static int getUserID(int InviteCode) {
		return InviteCode - HASH_INVITE_CODE;
	}
}

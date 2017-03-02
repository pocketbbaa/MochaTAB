package com.tab.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/***
 *
 * Log4j应用配置信息,在Spring环境中,spring会自动去把log4j的配置文件找到并做相关的初始化;
 *
 *
 */
public class Log4jUtil {

    // 系统日志, 记录异常信息;
    public static final Logger sysLog = Logger.getLogger("SYS");
    // Service Log
    public static final Logger svcLog = Logger.getLogger("SVC");
    // web Log
    public static final Logger webLog = Logger.getLogger("WEB");

    static {
        /** 静态块中初始化log4j **/
        PropertyConfigurator
                .configure(PublicUtil.class.getClassLoader().getResource("log4j.properties").getFile());
    }

    /***
     * 异常日志;
     *
     * @param exp
     */
    public static void exception(Exception exp) {
        if (exp == null) {
            sysLog.error("unknown error");
            return;
        }
        try {
            StackTraceElement[] s = exp.getStackTrace();
            // 针对java.lang.NollPointerException的异常;
            // exp.getMessage()返回为null;
            String expMes = PublicUtil.getTrimIfNullValueBlank(exp.getMessage());
            StringBuffer em = new StringBuffer(expMes);
            if (s != null) {
                for (int i = 0; i < s.length; i++) {
                    StackTraceElement st = s[i];
                    em.append("\t\t").append(st.toString()).append("\r\n");
                }
            }
            sysLog.error(em.toString());
        } catch (Exception excp) {
            excp.printStackTrace();
        }
    }

    /**
     * 解析异常
     *
     * @param e
     * @return
     */
    public static String parseExp(Exception e) {
        if (null == e) {
            return "unknown error";
        }
        StackTraceElement[] s = e.getStackTrace();
        String expMes = PublicUtil.getTrimIfNullValueBlank(e.getMessage());
        StringBuffer em = new StringBuffer(expMes);
        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                StackTraceElement st = s[i];
                em.append("\t\t").append(st.toString()).append("\r\n");
            }
        }
        return em.toString();
    }

    /**
     * getLogger
     *
     * @param logName
     * @return
     */
    public static Logger getLogger(String logName) {
        if (logName == null || logName.trim().length() == 0) {
            return null;
        }
        try {
            return Logger.getLogger(logName);
        } catch (Exception excp) {
            excp.printStackTrace();
            Log4jUtil.exception(excp);
        }
        return null;
    }

    public static void main(String[] arg) {
        System.out.println(PublicUtil.class.getClassLoader().getResource("log4j.properties"));
    }
}

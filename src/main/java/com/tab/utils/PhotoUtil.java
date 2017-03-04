package com.tab.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 图片地址转换
 * Created by Administrator on 2017/3/4 0004.
 */
public class PhotoUtil {

    /***
     * 抹茶商品图片前缀(阿里)
     */
    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX = "https://img.immocha.com";
    /***
     * 抹茶商品图片前缀(阿里)
     */
    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX_1 = "https://img.immocha.com/";


    /***
     * 通过图片的URI, 得到包含域名的完整URL路径;
     */
    public static final String getDomainPic(String picURL) {
        picURL = picURL.trim();
        if (StringUtils.startsWithIgnoreCase(picURL, "http")) {
            return picURL;
        }
        return buildAliURL(picURL);
    }

    /**
     * 合成Ali图片链接
     */
    public static String buildAliURL(String path) {
        if (StringUtils.isBlank(path)) {
            return path;
        }
        if (path.startsWith("/")) {
            return URL_MOCHA_IMAGE_ALI_PFEFIX + path;
        } else {
            return URL_MOCHA_IMAGE_ALI_PFEFIX_1 + path;
        }
    }
}

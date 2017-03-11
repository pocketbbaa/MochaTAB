package com.tab.utils;

import com.yunyao.upyun.up.UpYun;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
public class FileUploadUtil {


    private static final Logger log = Log4jUtil.svcLog;
    //    private static final String IMG_TEMP_DIR = "/home/crawler/email_image/";
    private static final String IMG_TEMP_DIR = "f://";

    private static final String TAB_IMG_PATH = "/data/log";

    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX = "https://img.immocha.com";
    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX_1 = "https://img.immocha.com/";


    public static String uploadImg(byte[] bytes, String filename) {
        Calendar time = Calendar.getInstance();
        String timeData = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH) + 1)
                + String.valueOf(time.get(Calendar.DATE)) + String.valueOf(time.get(Calendar.MINUTE))
                + String.valueOf(time.get(Calendar.SECOND));
//        String timeData = new Date().toString();

        String filePath = IMG_TEMP_DIR;
        String fileName = filename + new Date().getTime() + timeData + ".jpg";

        getFile(bytes, filePath, fileName);
        filePath = filePath + fileName;
        return local_upload_pic2upyunNoName(filePath, TAB_IMG_PATH);
    }


    private static void getFile(byte[] bfile, final String filePath, final String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 将本地的图片文件上传至upyun,并返回上传后的URL;
     *
     * @param url     原URL
     * @param dirRoot upai的目录分级 如
     * @return
     */
    private static String local_upload_pic2upyunNoName(final String picPath, final String dirRoot) {
        final UpYun upyun = new UpYun("mocha-image", "admin", "yunyao4admin");
        upyun.setTimeout(60);
        final File file = new File(picPath);
        if (!file.exists()) {
            System.out.println("file not found!!!");
            return null;
        }

        try {
            int width = 0;
            int height = 0;
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                width = bufferedImage.getWidth();
                height = bufferedImage.getHeight();
            } catch (Exception exp) {
                exp.printStackTrace();
                log.error(exp.getMessage());
            } finally {
                if (width == 0 || height == 0) {
                    width = 640;
                    height = 360;
                }
            }
            upyun.setContentMD5(UpYun.md5(file));
            upyun.getFileInfo(picPath);
            final String filePath = dirRoot + "/" + width + "x" + height + "/" + file.getName();
            final boolean result = upyun.writeFile(filePath, file, true);
            if (result) {
                return filePath;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
            log.error(exp.getMessage());
        }
        return null;
    }

    public static final String getDomainPic(String picUrl) {
        if (StringUtils.isBlank(picUrl)) {
            return StringUtils.EMPTY;
        }
        picUrl = picUrl.trim();
        if (StringUtils.startsWithIgnoreCase(picUrl, "http")) {
            return picUrl;
        }
        // 图片数据迁移- upai&qiniu 数据全部迁移至 ali.  by liux 2016-12-15
        return buildAliURL(picUrl);
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

    /**
     * 返回文件真实名
     *
     * @param fileName
     * @return
     */
    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.getBytes().length - 4);
    }

    public static void main(String[] args) {

        Calendar time = Calendar.getInstance();
        String timeData = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH) + 1)
                + String.valueOf(time.get(Calendar.DATE)) + String.valueOf(time.get(Calendar.MINUTE))
                + String.valueOf(time.get(Calendar.SECOND));

        System.out.println(timeData);

        System.out.println(time.get(Calendar.ZONE_OFFSET));

        System.out.println(new Date().getTime());
    }

}

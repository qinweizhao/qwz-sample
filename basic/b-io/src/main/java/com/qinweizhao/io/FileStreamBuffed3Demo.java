package com.qinweizhao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileStreamBuffed3Demo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream("d:/itbz.jpg");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("d:/ff.jpg");
            bos = new BufferedOutputStream(fos);
            //缓冲流中的byte数组长度默认是8192
            int temp = 0;
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //注意：关闭流顺序："后开的先关闭"
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

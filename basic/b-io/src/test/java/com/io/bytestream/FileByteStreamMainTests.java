package com.io.bytestream;

import com.io.FileByteStreamMain;
import org.junit.jupiter.api.Test;

/**
 * @author qinweizhao
 */
class FileByteStreamMainTests {


    /**
     * 读取文件内容
     * 中文乱码
     */
    @Test
    void readString() {
        String fileName = "src/main/resources/io/read.txt";
        FileByteStreamMain.readString(fileName);
    }

    /**
     * 读取文件内容
     * 解决中文乱码
     */
    @Test
    void readStringPlus() {
        String fileName = "src/main/resources/io/read.txt";
        FileByteStreamMain.readStringPlus(fileName);
    }

    /**
     * 写入到文件中
     */
    @Test
    void writeString() {
        String str = "hello word";
        FileByteStreamMain.writeString(str);
    }




//    @Test
//    void pdf(HttpServletResponse response){
//        response.setContentType("application/pdf");
//        FileInputStream in = null;
//        OutputStream out;
//        BufferedInputStream bis = null;
//
//        //路径
//        String path = "/Users/weizhao/Data/spring.pdf";
//        File file = new File(path);
//        if (file.exists()) {
//            try {
//                in = new FileInputStream(file);
//                bis= new BufferedInputStream(in);
//                out = response.getOutputStream();
//                byte[] b = new byte[512];
//                while ((bis.read(b)) != -1) {
//                    out.write(b);
//                    out.flush();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                if (bis != null) {
//                    try {
//                        bis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (in != null) {
//                    try {
//                        in.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
}
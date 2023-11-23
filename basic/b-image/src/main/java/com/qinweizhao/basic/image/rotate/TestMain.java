package com.qinweizhao.basic.image.rotate;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;

import java.io.File;

public class TestMain {


    public static void main(String[] args) throws Exception {

//        File file = new File("C:\\Users\\YVKG\\Pictures\\01.png");
        File file = new File("C:\\Users\\YVKG\\Desktop\\exif.png");
        // 1.获取图片的元数据

        Metadata metadata = ImageMetadataReader.readMetadata(file);

        System.out.println("metadata = " + metadata);

        // 2.图片元数据处理那种方向
        int orientation = 0;
        for (Directory directory : metadata.getDirectories()) {
            // 3.只需要TAG_ORIENTATION的数据即可。
            if(directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)){
                for (Tag tag : directory.getTags()) {
                    System.out.println("tag = " + tag);
                }
                orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
                System.out.println("orientation = " + orientation);
            }
        }

    }
}

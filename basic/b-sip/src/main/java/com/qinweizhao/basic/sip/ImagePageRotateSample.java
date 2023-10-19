package com.qinweizhao.basic.sip;


import com.yetech.libsip.contants.BindSide;
import com.yetech.libsip.contants.Orientation;
import com.yetech.libsip.contants.Plex;
import com.yetech.libsip.contants.Transparent;
import com.yetech.libsip.core.SipMeta;
import com.yetech.libsip.core.element.SipArea;
import com.yetech.libsip.core.element.SipBlock;
import com.yetech.libsip.model.SipAreaInfo;
import com.yetech.libsip.util.SystemUtils;

/**
 * 设置图像指定页旋转示例
 *
 */
public class ImagePageRotateSample {
    static {
        if (SystemUtils.isWindows()) {
            System.out.println("当前操作系统：Windows");
            String libsipDllName = "D:\\libdll\\libsip.dll";
            System.load(libsipDllName);
        } else if (SystemUtils.isLinux()) {
            System.out.println("当前操作系统：Linux");
            String libsipDllName = "/home/Data/libsip.so";
            System.load(libsipDllName);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello SIP Meta for Java!");
        // 生成Meta XML File文件名称
        String metaFileName = "D:\\libdll\\libsip\\sample\\Meta\\sample_meta_01.xml";
        // 创建Meta,并返回Meta唯一主键id
        long metaId = SipMeta.NewMeta(metaFileName, "Job描述", "创建人",0);
        System.out.println("Meta Id=" + metaId);
        // 创建SubJob
        long newSubjobReturnCode = SipMeta.NewSubjob(metaId, "SubJob描述", Plex.DUPLEX, BindSide.NONE, 0);
        System.out.println("NewSubjob ReturnCode=" + newSubjobReturnCode);
        // 添加页面
        long setMediaReturnCode = SipMeta.SetMedia(metaId, "A4:PLAIN:WHITE:80", Orientation.PORT);
        System.out.println("SetMedia ReturnCode=" + setMediaReturnCode);
        // 添加图层
        SipAreaInfo areaInfo = new SipAreaInfo();
        areaInfo.setXpos(0L).setYpos(0L).setLevel(0L).setOrientation(Orientation.PORT).setTransparent(Transparent.NONE).setWidth(210000).setHeight(297000);
        long areaId = SipArea.NewArea(metaId, "Area_1", areaInfo);
        System.out.println("NewArea,areaId=" + areaId);
        // 加载图像
        long imageId = SipBlock.ImageOpen(metaId,"", "D:\\libdll\\libsip\\images\\logo\\A01.tif");
        System.out.println("ImageOpen,imageId=" + imageId);
        // 设置图像指定页旋转
        long imagePageRotateReturnCode = SipBlock.ImagePageRotate(metaId, imageId, 1, 90000);
        System.out.println("ImagePageRotate,ReturnCode==" + imagePageRotateReturnCode);
        // 添加图像指定页
        long imagePutReturnCode = SipBlock.ImagePut(metaId, areaId, imageId, 1, 0, 0);
        System.out.println("ImagePut,ReturnCode==" + imagePutReturnCode);
        // 关闭图像
        long imageCloseReturnCode = SipBlock.ImageClose(metaId, imageId);
        System.out.println("ImageClose,ReturnCode=" + imageCloseReturnCode);
        // 关闭页面
        long formFeedReturnCode = SipMeta.FormFeed(metaId);
        System.out.println("FormFeed ReturnCode=" + formFeedReturnCode);
        // 关闭SubJob
        long closeSubjobReturnCode = SipMeta.CloseSubjob(metaId);
        System.out.println("CloseSubjob ReturnCode=" + closeSubjobReturnCode);
        // 关闭Meta
        SipMeta.CloseMeta(metaId);
    }
}

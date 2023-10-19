package com.qinweizhao.basic.sip;


import com.yetech.libsip.contants.BindSide;
import com.yetech.libsip.contants.Orientation;
import com.yetech.libsip.contants.Plex;
import com.yetech.libsip.contants.Transparent;
import com.yetech.libsip.core.SipMeta;
import com.yetech.libsip.core.element.SipArea;
import com.yetech.libsip.core.element.SipBlock;
import com.yetech.libsip.core.element.SipCursor;
import com.yetech.libsip.core.element.SipText;
import com.yetech.libsip.model.SipAreaInfo;
import com.yetech.libsip.util.SystemUtils;

/**
 * 添加文本坐标示例
 *
 */
public class TextOutSample {
    static {
        if (SystemUtils.isWindows()) {
            System.out.println("当前操作系统：Windows");
            String libsipDllName = "C:\\Users\\YVKG\\Desktop\\lib\\libsip.dll";
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
        String metaFileName = "C:\\Users\\YVKG\\Desktop\\SIP-20231016\\sample_meta_01.xml";
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

        // 设置英文字体
        long setAscFontReturnCode = SipText.SetAscFont(metaId, "微软雅黑");
        System.out.println("SetAscFont,ReturnCode=" + setAscFontReturnCode);

        // 设置文本坐标
        long setCursorPosReturnCode = SipCursor.SetCursorPos(metaId, areaId, 10000, 10000);
        System.out.println("SetCursorPos ReturnCode=" + setCursorPosReturnCode);
        // 添加文本1
        long textOutReturnCode1 = SipText.TextOut(metaId, areaId, "添加文本一");
        System.out.println("TextOut,ReturnCode=" + textOutReturnCode1);
        // 添加文本2
        long textOutReturnCode2 = SipText.TextOut(metaId, areaId, "添加文本二");
        System.out.println("TextOut,ReturnCode=" + textOutReturnCode2);
        // 结束段落
        long lineFeedReturnCode = SipText.LineFeed(metaId, areaId);
        System.out.println("LineFeed,ReturnCode=" + lineFeedReturnCode);


        // 关闭页面
        long formFeedReturnCode = SipMeta.FormFeed(metaId);

        // 添加页面
        long setMediaReturnCode2 = SipMeta.SetMedia(metaId, "A4:PLAIN:WHITE:80", Orientation.PORT);
        System.out.println("SetMedia ReturnCode=" + setMediaReturnCode2);
        // 添加图层
        SipAreaInfo areaInfo2 = new SipAreaInfo();
        areaInfo2.setXpos(0L).setYpos(0L).setLevel(0L).setOrientation(Orientation.PORT).setTransparent(Transparent.NONE).setWidth(210000).setHeight(297000);
        long areaId2 = SipArea.NewArea(metaId, "Area_1", areaInfo2);
        System.out.println("NewArea,areaId=" + areaId2);
        // 加载图像
        long imageId = SipBlock.ImageOpen(metaId,"", "C:\\Users\\YVKG\\Desktop\\SIP-20231016\\9227.png");
        System.out.println("ImageOpen,imageId=" + imageId);
        // 关闭页面
        long formFeedReturnCode2 = SipMeta.FormFeed(metaId);
        System.out.println("FormFeed ReturnCode=" + formFeedReturnCode2);


        System.out.println("FormFeed ReturnCode=" + formFeedReturnCode);
        // 关闭SubJob
        long closeSubjobReturnCode = SipMeta.CloseSubjob(metaId);
        System.out.println("CloseSubjob ReturnCode=" + closeSubjobReturnCode);
        // 关闭Meta
        SipMeta.CloseMeta(metaId);
    }


    public static void test(){
        String metaFileName="";
        String jobDesc="描述";
        String creator="作者";
        long nonPrintMargin = 0;

        long metaId = SipMeta.NewMeta(metaFileName, jobDesc, creator, nonPrintMargin);
        System.out.println("mateId:"+metaId);

        long subJobId = SipMeta.NewSubjob(metaId, jobDesc, Plex.DUPLEX, BindSide.BIND_LEFT, 0);
        System.out.println("subJobId:"+subJobId);



    }











}

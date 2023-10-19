package com.qinweizhao.basic.sip;


import com.yetech.libsip.contants.BindSide;
import com.yetech.libsip.contants.Plex;
import com.yetech.libsip.core.SipMeta;
import com.yetech.libsip.model.SipJobInfo;
import com.yetech.libsip.model.SipSubjobInfo;
import com.yetech.libsip.util.SystemUtils;

/**
 * 创建Meta示例
 *
 */
public class NewMetaSample {
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
        long metaId = SipMeta.NewMeta(metaFileName, "Job描述", "创建人",1);
        System.out.println("Meta Id=" + metaId);

        // 创建SubJob
        long newSubjobReturnCode = SipMeta.NewSubjob(metaId, "SubJob-1", Plex.DUPLEX, BindSide.NONE, 1);
        System.out.println("NewSubjob ReturnCode=" + newSubjobReturnCode);

        SipSubjobInfo sipSubjobInfo = SipMeta.GetSubjobInfo(metaId);
        System.out.println(sipSubjobInfo);

        long l = SipMeta.CloseSubjob(metaId);
        System.out.println("CloseSubjob="+l);

    // 创建SubJob
        long newSubjobRetCode = SipMeta.NewSubjob(metaId, "SubJob-2", Plex.DUPLEX, BindSide.NONE, 1);
        System.out.println("NewSubjob ReturnCode=" + newSubjobRetCode);

        long sl = SipMeta.GetTotalSubjob(metaId);
        System.out.println(sl);
        SipSubjobInfo sipSubjobInfo2 = SipMeta.GetSubjobInfo(metaId);
        System.out.println(sipSubjobInfo2);

        // 关闭Meta
        SipMeta.CloseMeta(metaId);
    }
}

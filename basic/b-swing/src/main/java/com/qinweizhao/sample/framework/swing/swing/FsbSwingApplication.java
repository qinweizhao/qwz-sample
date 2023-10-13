package com.qinweizhao.sample.framework.swing.swing;

import com.qinweizhao.sample.framework.swing.swing.area.SwingArea;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


public class FsbSwingApplication {


    public static void main(String[] args) {

        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            SwingArea.getInstance().initUI();
        } catch(Exception e) {
            System.out.println("报错了");
        }

    }

}

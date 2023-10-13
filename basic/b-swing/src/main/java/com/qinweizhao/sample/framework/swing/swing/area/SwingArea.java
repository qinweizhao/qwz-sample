package com.qinweizhao.sample.framework.swing.swing.area;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextPaneUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.TextUI;
import java.awt.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class SwingArea extends JFrame {
    private static SwingArea instance = null;
    private JProgressBar progressBar;

    private SwingArea() {
    }

    public static SwingArea getInstance() {
        if (null == instance) {
            synchronized (SwingArea.class) {
                if (null == instance) {
                    instance = new SwingArea();
                }
            }
        }
        return instance;
    }

    public void initUI() {
        this.setTitle("Sip Error Message");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 700, 540);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setContentPane(panel);
        //文本区域
        JLabel fileFildTitle = new JLabel("Error Code：");
        fileFildTitle.setBounds(100, 100, 150, 30);
        panel.add(fileFildTitle);

        JTextField textField = new JTextField();
        textField.setBounds(220, 100, 100, 30);
        textField.setFont(new Font("宋体", Font.BOLD, 15));
        textField.setForeground(Color.black);//字体颜色
        panel.add(textField);


        JButton action = new JButton("查询");
        action.setBounds(370, 100, 100, 30);
//        action.addActionListener(e -> action(file.get()));
        action.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        action.setFont(new Font("宋体", Font.BOLD, 15));
        action.setForeground(Color.white);
        panel.add(action);

        JLabel msgLabel = new JLabel("Error Message：");
        msgLabel.setBounds(100, 150, 150, 30);
        panel.add(msgLabel);

        JTextArea textArea = new JTextArea("错以上就是关于 Java 图形界面以上就是关于 Java 图形界面工具类 Swing 中的文本域组件 JTextArea 的具体实例用法的全部内容，想要了解更多关于 Java 图形界面工具类 Swing 的其他组件的应用，可以在W3Cschool中搜索相应的文章内容。如果本篇文章对您的学习有所帮助，还希以上就是关于 Java 图形界面工具类 Swing 中的文本域组件 JTextArea 的具体实例用法的全部内容，想要了解更多关于 Java 图形界面工具类 Swing 的其他组件的应用，可以在W3Cschool中搜索以上就是关于 Java 图形界面工具类 Swing 中的文本域组件 JTextArea 的具体实例用法的全部内容，想要了解更多关于 Java 图形界面工具类 Swing 的其他组件的应用，可以在W3Cschool中搜索相应的文章内容。如果本篇文章对您的学习有所帮助，还希望大家对我们能够多多地关注和支持！以上就是关于 Java 图形界面工具类 Swing 中的文本域组件 JTextArea 的具体实例用法的全部内容，想要了解更多关于 Java 图形界面工具类 Swing 的其他组件的应用，可以在W3Cschool中搜索相应的文章内容。如果本篇文章对您的学习有所帮助，还希望大家对我们能够多多地关注和支持！相应的文章内容。如果本篇文章对您的学习有所帮助，还希望大家对我们能够多多地关注和支持！望大家对我们能够多多地关注和支持！工具类 Swing 中的文本域组件 JTextArea 的具体实例用法的全部内容，想要了解更多关于 Java 图形界面工具类 Swing 的其他组件的应用，可以在W3Cschool中搜索相应的文章内容。如果本篇文章对您的学习有所帮助，还希望大家对我们能够多多地关注和支持！误详情",5, 5);
//        textArea.setBounds(100,190,450,200);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.red);


        JScrollPane jsp=new JScrollPane(textArea);// 将文本域放在滚动条的面板上
        jsp.setBounds(100,190,450,200);// 设置滚动面板的坐标和大小

        textField.setFont(new Font("宋体", Font.BOLD, 15));

        panel.add(jsp);
//        panel.add(textArea);



        this.setVisible(true);

    }

    /**
     * 进度条模拟程序
     *
     * @param progressBar
     */
    private void progressBar(JProgressBar progressBar) {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(i);
            }
        }).start();
    }

    private void action(JFileChooser fileChooser) {
        if (null == fileChooser || null == fileChooser.getSelectedFile()) {
            JOptionPane.showMessageDialog(null, "请先选择要处理的文件！╮(╯▽╰)╭", "警告！", JOptionPane.WARNING_MESSAGE);
            return;
        }
        System.out.println("执行" + fileChooser.getSelectedFile().getAbsolutePath());
        progressBar(progressBar);

    }

    /*
     * 打开文件
     */
    private JFileChooser showFileOpenDialog(Component parent, JLabel textField) {

        if (progressBar.getValue() != 0 && progressBar.getValue() != 100) {
            JOptionPane.showMessageDialog(null, "计算过程中，不可更改文件！╮(╯▽╰)╭", "警告！", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setMultiSelectionEnabled(false);
        // 设置默认使用的文件过滤器
        jFileChooser.setFileFilter(new FileNameExtensionFilter("excel(*.xlsx, *.xls)", "xls", "xlsx"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = jFileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = jFileChooser.getSelectedFile();

            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
            // File[] files = fileChooser.getSelectedFiles();
            textField.setText("");
            textField.setText(file.getName() + "\n\n");
        }
        //进度条归零
        progressBar.setValue(0);
        return jFileChooser;
    }
}



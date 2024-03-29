package com.qinweizhao.framework.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 代码生成器（新），适用版本：3.5.1 及其以上版本，对历史版本不兼容！
 * 详细配置参考：https://baomidou.com/pages/56bac0/
 *
 * @author qinweizhao
 */
public class FastGenerator {

    public static void main(String[] args) {
        // String property = System.getProperty("user.dir");
        String property = "";
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/new_mall_all?serverTimezone=UTC", "root", "Qwz#1201")
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("qinweizhao")
                            // 开启 swagger 模式
//                            .enableSwagger()
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir(property + "/Users/weizhao/Code/generator/src/main/java");
                })
                .packageConfig(builder -> builder
                        // 设置父包名
                        .parent("com.qinweizhao")
                        // 设置父包模块名
                        .moduleName("product")
                        // 设置mapperXml生成路径
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, property + "/Users/weizhao/Code/generator/src/main/resources/mapper")))
                .strategyConfig(builder -> {
                    builder
                            // Collections.emptyList()
                            // 全部
                            .addInclude(Collections.emptyList())
                            //.addInclude("sys_log")
                            // 忽略那些表
                            //.addExclude("a")
                            // Mapper 策略配置
                            .controllerBuilder().enableRestStyle()
                            .mapperBuilder()
                            // 启用 BaseResultMap 生成
                            .enableBaseResultMap()
                            // 启用 BaseColumnList
                            .enableBaseColumnList()
                            .serviceBuilder()
                            .entityBuilder().enableLombok()
                    // 设置需要生成的表名
                    //.addTablePrefix("sys_")
                    ; // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}

package com.smile.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.smile.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        // 实现config命令的逻辑
        System.out.println("查看参数信息");

        // 反射方式1：JDK原生语法
//        Class<?> myClass = MainTemplateConfig.class;
//        Field[] fields = myClass.getDeclaredFields();

        // 反射方式2：hutool反射工具类
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        // 打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("-----");
        }
    }
}

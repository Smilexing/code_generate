package com.smile.generator;

import com.smile.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("smilexin");
        dataModel.setLoop(false);
        dataModel.setOutputText("最终の求和结果：");
        doGenerate(dataModel);
    }

    /**
     * 生成静态文件和动态文件
     *
     * @param model
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 当前idea打开的窗口
        String projectPath = System.getProperty("user.dir");
        // 找整个项目的根路径 smilexin-generator
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径 ACM的示例模板 在smilexin-generator-demo-projects 目录下
        String inputPath = new File(projectPath + File.separator + "smilexin-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;

        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        // 生成动态文件，会覆盖部分已生成的静态文件
        String inputDynamicFilePath = projectPath + File.separator + File.separator + "smilexin-generator-basic" + File.separator+ "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/c·om/yupi/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}

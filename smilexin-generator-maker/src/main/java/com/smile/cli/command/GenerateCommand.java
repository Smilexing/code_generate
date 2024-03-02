package com.smile.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.smile.generator.FileGenerator;
import com.smile.model.DataModel;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name="generate",description = "生成代码",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
    @CommandLine.Option(names={"-l","--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @CommandLine.Option(names={"-a","--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private  String auther;

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText;

    public Integer call() throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("配置信息"+ dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }

}

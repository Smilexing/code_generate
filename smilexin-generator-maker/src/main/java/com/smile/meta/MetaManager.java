package com.smile.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/3/2 10:38
 */
public class MetaManager {

    private static volatile Meta meta;

    public static Meta getMetaObject(){
        if(meta == null)
        {
//            加锁
            synchronized (MetaManager.class){
                if(meta==null)
                {
                    meta=initMeta();
                }
            }
        }
        return meta;
    }

//    私有构造函数，防止利用new的方式创建
    private static Meta initMeta(){
        String metaJson= ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);

//        todo 校验配置文件，处理默认值
        return newMeta;
    }
}

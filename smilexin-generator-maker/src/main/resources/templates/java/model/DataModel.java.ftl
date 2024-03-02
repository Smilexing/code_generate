package ${basePackage}.model;

import lombok.Data;

/**
* 数据模型
*/
@Data
public class DataModel {
<#list modelConfig.models as model>
    <#if model.groupKey??>
        // ${model.groupName}
        <#list model.models as submodel>
            <#if submodel.fieldName??>
                <#if submodel.description??>
                    /**
                    * ${submodel.description}
                    */
                </#if>
                private ${submodel.type} ${submodel.fieldName}<#if submodel.defaultValue??> = ${submodel.defaultValue?c}</#if>;
            </#if>
        </#list>
    <#else>
        <#if model.fieldName??>
            <#if model.description??>
                /**
                * ${model.description}
                */
            </#if>
            private ${model.type} ${model.fieldName}<#if model.defaultValue??> = ${model.defaultValue?c}</#if>;
        </#if>
    </#if>
</#list>
}

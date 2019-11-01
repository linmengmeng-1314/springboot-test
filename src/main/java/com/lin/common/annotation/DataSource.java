package com.lin.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lin.common.baseenum.DataSourceEnum;

/**
 * @Desc   : <P>TODO<P>
 * @Author : SOHU-wanghonghui
 * @Date   : 2016年11月21日 下午5:56:47
 * @Version: V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	DataSourceEnum value() default DataSourceEnum.DATASOURCE_MASTER;
}

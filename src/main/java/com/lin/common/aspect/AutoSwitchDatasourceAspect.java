package com.lin.common.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lin.common.annotation.DataSource;
import com.lin.datasource.MultiDataSource;

@Aspect
@Component
@Order(-1)
public class AutoSwitchDatasourceAspect {

	
	@Pointcut("@annotation(com.lin.common.annotation.DataSource)")
	public void logPointCut() { 
		
	}
	@Before("logPointCut()&& @annotation(ds)")
	public void before(DataSource ds) {
		MultiDataSource.switchSource(ds.value());
	}
	@After("logPointCut()&& @annotation(ds)")
	public void after(DataSource ds) {
		MultiDataSource.clear();
	}
}

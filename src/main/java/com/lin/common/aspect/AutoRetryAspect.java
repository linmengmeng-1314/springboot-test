package com.lin.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lin.common.annotation.AutoRetry;
import com.lin.common.exception.AutoRetryException;

/**
 * @Desc   : 循环操作切面
 * 在需要循环操作的方法上添加@AutoRetry
 * @Author : SOHU-刘杰
 * @Date   : 2016年11月25日 下午4:29:28
 * @Version: V1.0
 */
@Component
@Aspect
@Order(-1)
public class AutoRetryAspect {

	@Around(value = "@annotation(autoRetry)")
	public Object doAround(ProceedingJoinPoint pjp, AutoRetry autoRetry) throws Throwable {
		Object obj = null;
		boolean retry = false;
		int currentRetrtCount = 0;
		do {
			if (currentRetrtCount < autoRetry.value()) {
				try {
					retry = false;
					obj = pjp.proceed();
				    
				} catch (AutoRetryException e) {
					retry = true;
					++currentRetrtCount;
					Thread.sleep(autoRetry.waitTime());
					throw e;
				}
			} else {
				ContextLog.info("乐观锁重试提交动作", "第 "+currentRetrtCount+" 重试", "admin.common.aspect.AutoRetryAspect.doAround", AutoRetryAspect.class);
			}
		} while (retry);
		return obj;
	}
}

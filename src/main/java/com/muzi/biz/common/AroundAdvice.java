package com.muzi.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AroundAdvice {

	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName();
		Object obj = null;
		long start = System.currentTimeMillis();
		
		// 클라이언트가 호출한 비즈니스 메소드가 여기에서 실행됨
		obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(method +"() 메소드 수행에 소요된 시간 : " + (end - start) + "(ms)초");
		return obj;
	}
}

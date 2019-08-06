package com.muzi.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service
@Aspect	//Pointcut + advice(printLog)
public class LogAdvice {
//	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
//	public void allPointcut() {}	//로직을 처리할 목적이 아님. 식별자로써 사용 참조형 메소드
//	
//	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
//	public void getPointcut() {}	//로직을 처리할 목적이 아님. 식별자로써 사용 참조형 메소드
	
	//@Before("getPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method + 
			"() 메소드 ARGS 정보 : " + args[0].toString());
	}
}

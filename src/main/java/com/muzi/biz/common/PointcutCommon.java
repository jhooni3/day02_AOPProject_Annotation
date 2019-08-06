package com.muzi.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.user.*Impl.get*(..))")
	public void userPointcut() {}
}

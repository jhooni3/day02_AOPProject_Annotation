package com.muzi.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void excepionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + 
			"() 메소드 수행 중 예외발생!!!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0번 글을 등록할 수는 없어요.");
		} else if(exceptObj instanceof ArithmeticException) {
			System.out.println("정수를 0으로 나눌 수는 없어요.");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL 구문에 오류가 있네요.");
		} else {
			System.out.println("원인 모를 문제 발생!!!");
		}
	}
}

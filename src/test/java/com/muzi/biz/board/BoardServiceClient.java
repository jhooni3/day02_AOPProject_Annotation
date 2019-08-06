package com.muzi.biz.board;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 구동한다.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("business-layer.xml");
		
		// 2. 컨테이너로부터 테스트할 BoardService 타입의 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. Lookup한 객체의 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(0);
		vo.setTitle("임시 제목1");
		vo.setWriter("테스터");
		vo.setContent("임시 내용..................");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("[ BOARD LIST ]");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}

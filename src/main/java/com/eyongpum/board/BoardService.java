package com.eyongpum.board;

public class BoardService {
	private static BoardService _instance;
	private BoardDao boardDao;
	public BoardService() throws Exception {
		boardDao = new BoardDao();
	}
	
	public static BoardService getInstance() throws Exception {
		if (_instance == null) {
			_instance = new BoardService();
		}
		return _instance;
	}

}

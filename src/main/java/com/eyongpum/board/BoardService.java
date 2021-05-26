package com.eyongpum.board;

import java.util.List;

import com.eyongpum.util.PageMaker;
import com.eyongpum.util.PageCalculator;

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
	
	public int remove(int boardNo) throws Exception, BoardException {
		Board tempBoard = boardDao.findBoard(boardNo);
		boolean rExist = boardDao.countReplay(tempBoard);
		System.out.println("reply exist : "+ rExist);
		if (boardDao.countReplay(tempBoard)) {
			throw new BoardException("You cannot remove the board with reply.");
		} else {
			return boardDao.remove(tempBoard.getBoardNo());
		}
	}
	
	public int create(Board board) throws Exception {
		return boardDao.create(board);
	}
	
	public int createReply(Board board) throws Exception {
		return boardDao.createReply(board);
	}
	
	public Board findBoard(int boardNo) throws Exception {
		Board board = boardDao.findBoard(boardNo);
		return board;
	}
	
	public void updateHitCount(int boardNo) throws Exception {
		boardDao.increaseReadCount(boardNo);
	}
	
	public BoardListPageMakerDto findBoardList(int currentPage) throws Exception {
		int totalRecordCount = boardDao.getBoardCount();
		PageMaker pageMaker = new PageMaker(totalRecordCount,currentPage);
		List<Board> boardList = boardDao.findBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		
		BoardListPageMakerDto pageMakerBoardList = new BoardListPageMakerDto();
		pageMakerBoardList.totRecordCount = totalRecordCount;
		pageMakerBoardList.itemList = boardList;
		pageMakerBoardList.pageMaker = pageMaker;
		return pageMakerBoardList;
	}

}

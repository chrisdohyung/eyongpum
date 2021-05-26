package com.eyongpum.util;

import com.eyongpum.board.BoardListPageDto;

public class PageCalculator {
	public static BoardListPageDto getPagingInfo(
												int selectPage, 
												int rowCountPerPage, 
												int pageCountPerPage, 
												int totalRecordCount) {
		BoardListPageDto boardListPageDto = new BoardListPageDto();
		int totalPageCount = 1;
		int startPageNo = 1;
		int endPageNo = 1;
		int selectPageNo = 1;
		int previousGroupStartPageNo = 1;
		int nextGroupStartPageNo = 1;
		int groupNo = 0;
		int startRow = 0;
		int endRow = 0;
		int modula = 0;
		if (totalRecordCount > 1) {
			modula = (totalRecordCount) % rowCountPerPage;
			if (modula != 0) {
				modula = 1;
			} else {
				modula = 0;
			}
			totalPageCount = (totalPageCount)/rowCountPerPage + modula;
		} else {
			totalPageCount = 1;
		}
		
		selectPageNo = selectPage;
		groupNo = (selectPageNo-1)/pageCountPerPage;
		startPageNo = groupNo*pageCountPerPage + 1;
		endPageNo = groupNo*pageCountPerPage+pageCountPerPage;
		
		return boardListPageDto;
	}

}

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
		
		previousGroupStartPageNo = startPageNo - pageCountPerPage;
		if (previousGroupStartPageNo < 0) {
			previousGroupStartPageNo = 0;
		}
		nextGroupStartPageNo = startPageNo + pageCountPerPage;
		
		if (endPageNo > totalPageCount) {
			endPageNo = totalPageCount;
		}
		
		if (selectPageNo == 1 && selectPageNo == totalPageCount) {
			startRow = 1;
			endRow = totalRecordCount;
		} else if (selectPageNo < totalPageCount) {
			startRow = rowCountPerPage * selectPageNo-rowCountPerPage + 1;
			endRow = rowCountPerPage * selectPageNo-rowCountPerPage + rowCountPerPage;
		} else if (selectPageNo == totalPageCount) {
			startRow = rowCountPerPage * selectPageNo - rowCountPerPage + 1;
			endRow = totalRecordCount;
		}
		
		boardListPageDto.setStartPageNo(startPageNo);
		boardListPageDto.setEndPageNo(endPageNo);
		boardListPageDto.setSelectPageNo(selectPageNo);
		boardListPageDto.setTotalRecordCount(totalRecordCount);
		boardListPageDto.setTotalPageCount(totalPageCount);
		boardListPageDto.setPreviousGroupStartPageNo(previousGroupStartPageNo);
		boardListPageDto.setNextGroupStartPageNo(nextGroupStartPageNo);
		boardListPageDto.setStartRowNum(startRow);
		boardListPageDto.setEndRowNum(endRow);
		boardListPageDto.setShowPreviousGroup(isShowPreviousMoreIcon(groupNo,totalPageCount));
		boardListPageDto.setShowNextGroup(isShowNextMoreIcon(endPageNo, totalPageCount));
		boardListPageDto.setShowFirst(isShowFirstIcon(groupNo, totalPageCount));
		boardListPageDto.setShowLast(isShowLastIcon(endPageNo, totalPageCount));
		
		return boardListPageDto;
	}
	
	public static boolean isShowPreviousMoreIcon(int groupNo, int totalPageCount) {
		boolean isShow = false;
		int modula = 0;
		modula = groupNo % totalPageCount;
		if (modula != 0) {
			modula = 1;
		}
		if ((groupNo / totalPageCount + modula) > 0) {
			isShow = true;
		} else {
			isShow = false;
		}
		return isShow;
	}
	
	public static boolean isShowNextMoreIcon(int endPageNo, int totalPageCount) {
		if (endPageNo < totalPageCount) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isShowFirstIcon(int groupNo, int totalPageCount) {
		int modula = 0;
		modula = groupNo % totalPageCount;
		if (modula != 0) {
			modula = 1;
		}
		if ((groupNo / totalPageCount + modula) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isShowLastIcon(int endPageNo, int totalPageCount) {
		if (endPageNo < totalPageCount) {
			return true;
		} else {
			return false;
		}
	}
	

}

package com.eyongpum.util;

public class PageMaker {
	
	public static final int PAGE_SCALE = 8;
	public static final int BLOCK_SCALE = 7;
	private int curPage;
	private int prevPage;
	private int nextPage;
	private int prevGroupStartPage;
	private int nextGroupStartPage;
	
	private int totPage;
	private int totBlock;
	private int curBlock;
	private int preBlock;
	private int nextBlock;
	
	private int pageBegin;
	private int pageEnd;
	
	private int blockBegin;
	private int blockEnd;
	
	public PageMaker(int count, int curPage) {
		curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock(count);
		setBlockRange();
	}
	
	public void setBlockRange() {
		curBlock = (int)Math.ceil((curPage-1) / BLOCK_SCALE)+1;
		blockBegin = (curBlock-1)*BLOCK_SCALE+1;
		blockEnd = blockBegin+BLOCK_SCALE-1;
		if (blockEnd > totPage) {
			blockEnd = totPage;
		}
		prevPage = curPage-1;
		nextPage = curPage+1;
		if(nextPage >= totPage) {
			nextPage = totPage;
		}
		prevGroupStartPage = blockBegin - BLOCK_SCALE;
		nextGroupStartPage = blockBegin + BLOCK_SCALE;
	}
	
	

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevGroupStartPage() {
		return prevGroupStartPage;
	}

	public void setPrevGroupStartPage(int prevGroupStartPage) {
		this.prevGroupStartPage = prevGroupStartPage;
	}
	
	public void setPageRange() {
		pageBegin = (curPage-1)*PAGE_SCALE+1;
		pageEnd = pageBegin + PAGE_SCALE-1;
	}
	
	public void setTotBlock(int count) {
		totBlock = (int)Math.ceil(count / BLOCK_SCALE);
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getNextGroupStartPage() {
		return nextGroupStartPage;
	}

	public void setNextGroupStartPage(int nextGroupStartPage) {
		this.nextGroupStartPage = nextGroupStartPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPreBlock() {
		return preBlock;
	}

	public void setPreBlock(int preBlock) {
		this.preBlock = preBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	public static int getPageScale() {
		return PAGE_SCALE;
	}

	public static int getBlockScale() {
		return BLOCK_SCALE;
	}

	
	

}

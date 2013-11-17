package com.eleven.booklibrary.model.vo;

public class Pagination {
  
  private long curPage;
  
  public long getCurPage() {
    return curPage;
  }

  public void setCurPage(long curPage) {
    this.curPage = curPage;
  }

  public long getPageSize() {
    return pageSize;
  }

  public void setPageSize(long pageSize) {
    this.pageSize = pageSize;
  }

  public long getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(long pageNumber) {
    this.pageNumber = pageNumber;
  }

  public long getItems() {
    return items;
  }

  public void setItems(long items) {
    this.items = items;
  }

  private long pageSize;
  
  private long pageNumber;
  
  private long items;

}

package com.zhuzb.common;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/5/16
 * Time：10:31
 */
public class BaseEntity {

    private int pageSize;

    private int pageNumber;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}

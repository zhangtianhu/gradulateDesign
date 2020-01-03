package com.travel.api.beans.request;

/**
 * Created by Administrator on 2018-01-23.
 */
public class BaseRequest {
    protected int pageSize;
    protected int pageNo;

    public int getPageSize() {
        if (pageSize < 1)
            pageSize = 10;
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        if (pageNo < 1)
            pageNo = 1;
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}

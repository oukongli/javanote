package com.shdev.oukongli.model;

import java.util.List;

/**
 * Created by ou_kongli on 2015/4/22.
 */
public class Pager<E> {
    private int pageSize;
    private int pageIndex;
    private int totalRecord;
    private int totalPage;
    private List<E> datas;
    private int pageOffSet;

    public int getPageOffSet() {
        return pageOffSet;
    }

    public void setPageOffSet(int pageOffSet) {
        this.pageOffSet = pageOffSet;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return (int)Math.ceil(totalRecord * 1.0/pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }
}

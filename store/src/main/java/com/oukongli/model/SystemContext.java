package com.oukongli.model;

/**
 * Created by ou_kongli on 2015/4/22.
 */
public class SystemContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageOffSet = new ThreadLocal<Integer>();

    public static int getPageOffSet() {
        return pageOffSet.get();
    }

    public static void setPageOffSet(int _pageOffSet) {
        pageOffSet.set(_pageOffSet);
    }

    public static void removePageOffset() {
        pageOffSet.remove();
    }

    public static void setPageSize(int _pageSize) {
        pageSize.set(_pageSize);
    }

    public static int getPageSize() {
        return pageSize.get();
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void setPageIndex(int _pageIndex) {
        pageIndex.set(_pageIndex);
    }

    public static int getPageIndex() {
        return pageIndex.get();
    }

    public static void removePageIndex() {
        pageIndex.remove();
    }
}

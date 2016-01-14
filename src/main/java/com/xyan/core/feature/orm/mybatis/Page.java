package com.xyan.core.feature.orm.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

/**
 * Mybatis分页参数及查询结果封装. 注意所有序号从1开始.
 * 
 * @param <T>
 *            Page中记录的类型.
 * @author StarZou
 * @since 2014年5月18日 下午1:34:32
 **/
public class Page<T> extends RowBounds {
    // --分页参数 --//
    /**
     * 页编号 : 第几页
     */
    public int pageNo = 1;
    /**
     * 页大小 : 每页的数量
     */
    public int pageSize = 10;

    /**
     * 偏移量 : 第一条数据在表中的位置
     */
    public int offset;

    /**
     * 限定数 : 每页的数量
     */
    public int limit;

    // --结果 --//
    /**
     * 查询结果
     */
    public List<T> result = new ArrayList<T>();

    /**
     * 总条数
     */
    public int totalCount;

    /**
     * 总页数
     */
    public int totalPages;

    // --计算 数据库 查询的参数 : LIMIT 3, 3; LIMIT offset, limit; --//
    /**
     * 计算偏移量
     */
    private Page<T> calcOffset() {
        this.offset = ((pageNo - 1) * pageSize);
        return this;
    }

    /**
     * 计算限定数
     */
    private Page<T> calcLimit() {
        this.limit = pageSize;
        return this;
    }

    // -- 构造函数 --//
    public Page() {
        this.calcOffset();
        this.calcLimit();
    }

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.calcOffset();
        this.calcLimit();
    }

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNo - 1) * pageSize) + 1;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
     */
    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    // -- 访问查询结果函数 --//
    /**
     * 取得页内的记录列表.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * 设置页内的记录列表.
     */
    public Page<T> setResult(final List<T> result) {
        this.result = result;
        return this;
    }

    /**
     * 取得总记录数, 默认值为-1.
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数.
     */
    public Page<T> setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = this.getTotalPages();
        return this;
    }

    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */
    public int getTotalPages() {
        if (totalCount <=0) {
            return 1;
        }
        int pages = totalCount / pageSize;
        return totalCount % pageSize > 0 ? ++pages : pages;
    }

    public Page<T> setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

	public Page<T> setPageNo(int pageNo) {
		this.pageNo = pageNo;
		return this;
	}

	public Page<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
 
}
